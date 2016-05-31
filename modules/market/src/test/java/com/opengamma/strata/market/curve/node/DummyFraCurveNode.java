/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve.node;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.basics.date.HolidayCalendars;
import com.opengamma.strata.basics.index.IborIndex;
import com.opengamma.strata.basics.market.MarketData;
import com.opengamma.strata.basics.market.ObservableId;
import com.opengamma.strata.market.ValueType;
import com.opengamma.strata.market.curve.CurveNode;
import com.opengamma.strata.market.param.DatedParameterMetadata;
import com.opengamma.strata.market.param.LabelDateParameterMetadata;

/**
 * Dummy curve node.
 * Based on a FRA.
 */
@BeanDefinition(style = "light")
public final class DummyFraCurveNode
    implements CurveNode, ImmutableBean, Serializable {

  @PropertyDefinition(validate = "notNull")
  private final Period periodToStart;
  @PropertyDefinition(validate = "notNull")
  private final Period periodToEnd;
  @PropertyDefinition(validate = "notNull")
  private final ObservableId rateId;
  @PropertyDefinition
  private final double spread;
  @PropertyDefinition(validate = "notEmpty", overrideGet = true)
  private final String label;

  //-------------------------------------------------------------------------
  public static DummyFraCurveNode of(Period periodToStart, IborIndex index, ObservableId rateId) {
    return new DummyFraCurveNode(periodToStart, periodToStart.plus(index.getTenor().getPeriod()), rateId, 0, "Dummy");
  }

  public static DummyFraCurveNode of(Period periodToStart, IborIndex index, ObservableId rateId, double spread) {
    return new DummyFraCurveNode(periodToStart, periodToStart.plus(index.getTenor().getPeriod()), rateId, spread, "Dummy");
  }

  //-------------------------------------------------------------------------
  @Override
  public Set<ObservableId> requirements() {
    return ImmutableSet.of(rateId);
  }

  @Override
  public DatedParameterMetadata metadata(LocalDate valuationDate, ReferenceData refData) {
    return LabelDateParameterMetadata.of(
        HolidayCalendars.SAT_SUN.nextOrSame(valuationDate.plus(periodToEnd)), periodToEnd.toString());
  }

  @Override
  public DummyFraTrade trade(LocalDate valuationDate, MarketData marketData, ReferenceData refData) {
    double fixedRate = marketData.getValue(rateId) + spread;
    return DummyFraTrade.of(valuationDate, fixedRate);
  }

  @Override
  public DummyFraTrade resolvedTrade(LocalDate valuationDate, MarketData marketData, ReferenceData refData) {
    return trade(valuationDate, marketData, refData);
  }

  @Override
  public double initialGuess(LocalDate valuationDate, MarketData marketData, ValueType valueType) {
    if (ValueType.ZERO_RATE.equals(valueType)) {
      return marketData.getValue(rateId);
    }
    return 0d;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code DummyFraCurveNode}.
   */
  private static MetaBean META_BEAN = LightMetaBean.of(DummyFraCurveNode.class);

  /**
   * The meta-bean for {@code DummyFraCurveNode}.
   * @return the meta-bean, not null
   */
  public static MetaBean meta() {
    return META_BEAN;
  }

  static {
    JodaBeanUtils.registerMetaBean(META_BEAN);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private DummyFraCurveNode(
      Period periodToStart,
      Period periodToEnd,
      ObservableId rateId,
      double spread,
      String label) {
    JodaBeanUtils.notNull(periodToStart, "periodToStart");
    JodaBeanUtils.notNull(periodToEnd, "periodToEnd");
    JodaBeanUtils.notNull(rateId, "rateId");
    JodaBeanUtils.notEmpty(label, "label");
    this.periodToStart = periodToStart;
    this.periodToEnd = periodToEnd;
    this.rateId = rateId;
    this.spread = spread;
    this.label = label;
  }

  @Override
  public MetaBean metaBean() {
    return META_BEAN;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the periodToStart.
   * @return the value of the property, not null
   */
  public Period getPeriodToStart() {
    return periodToStart;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the periodToEnd.
   * @return the value of the property, not null
   */
  public Period getPeriodToEnd() {
    return periodToEnd;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the rateId.
   * @return the value of the property, not null
   */
  public ObservableId getRateId() {
    return rateId;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the spread.
   * @return the value of the property
   */
  public double getSpread() {
    return spread;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the label.
   * @return the value of the property, not empty
   */
  @Override
  public String getLabel() {
    return label;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      DummyFraCurveNode other = (DummyFraCurveNode) obj;
      return JodaBeanUtils.equal(periodToStart, other.periodToStart) &&
          JodaBeanUtils.equal(periodToEnd, other.periodToEnd) &&
          JodaBeanUtils.equal(rateId, other.rateId) &&
          JodaBeanUtils.equal(spread, other.spread) &&
          JodaBeanUtils.equal(label, other.label);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(periodToStart);
    hash = hash * 31 + JodaBeanUtils.hashCode(periodToEnd);
    hash = hash * 31 + JodaBeanUtils.hashCode(rateId);
    hash = hash * 31 + JodaBeanUtils.hashCode(spread);
    hash = hash * 31 + JodaBeanUtils.hashCode(label);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(192);
    buf.append("DummyFraCurveNode{");
    buf.append("periodToStart").append('=').append(periodToStart).append(',').append(' ');
    buf.append("periodToEnd").append('=').append(periodToEnd).append(',').append(' ');
    buf.append("rateId").append('=').append(rateId).append(',').append(' ');
    buf.append("spread").append('=').append(spread).append(',').append(' ');
    buf.append("label").append('=').append(JodaBeanUtils.toString(label));
    buf.append('}');
    return buf.toString();
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
