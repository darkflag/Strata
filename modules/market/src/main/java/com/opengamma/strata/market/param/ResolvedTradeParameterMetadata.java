/**
 * Copyright (C) 2017 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.param;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.product.ResolvedTrade;

/**
 * Parameter metadata based on a resolved trade and label.
 */
@BeanDefinition
public final class ResolvedTradeParameterMetadata
    implements ParameterMetadata, ImmutableBean, Serializable {

  /**
   * The trade that describes the parameter.
   */
  @PropertyDefinition(validate = "notNull")
  private final ResolvedTrade trade;
  /**
   * The label that describes the parameter.
   */
  @PropertyDefinition(validate = "notEmpty", overrideGet = true)
  private final String label;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance specifying the trade and label.
   * 
   * @param trade  the resolved trade
   * @param label  the label
   * @return the instance
   */
  public static ResolvedTradeParameterMetadata of(ResolvedTrade trade, String label) {
    return new ResolvedTradeParameterMetadata(trade, label);
  }

  //-------------------------------------------------------------------------
  @Override
  public String getIdentifier() {
    return getLabel();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ResolvedTradeParameterMetadata}.
   * @return the meta-bean, not null
   */
  public static ResolvedTradeParameterMetadata.Meta meta() {
    return ResolvedTradeParameterMetadata.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ResolvedTradeParameterMetadata.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ResolvedTradeParameterMetadata.Builder builder() {
    return new ResolvedTradeParameterMetadata.Builder();
  }

  private ResolvedTradeParameterMetadata(
      ResolvedTrade trade,
      String label) {
    JodaBeanUtils.notNull(trade, "trade");
    JodaBeanUtils.notEmpty(label, "label");
    this.trade = trade;
    this.label = label;
  }

  @Override
  public ResolvedTradeParameterMetadata.Meta metaBean() {
    return ResolvedTradeParameterMetadata.Meta.INSTANCE;
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
   * Gets the trade that describes the parameter.
   * @return the value of the property, not null
   */
  public ResolvedTrade getTrade() {
    return trade;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the label that describes the parameter.
   * @return the value of the property, not empty
   */
  @Override
  public String getLabel() {
    return label;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ResolvedTradeParameterMetadata other = (ResolvedTradeParameterMetadata) obj;
      return JodaBeanUtils.equal(trade, other.trade) &&
          JodaBeanUtils.equal(label, other.label);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(trade);
    hash = hash * 31 + JodaBeanUtils.hashCode(label);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("ResolvedTradeParameterMetadata{");
    buf.append("trade").append('=').append(trade).append(',').append(' ');
    buf.append("label").append('=').append(JodaBeanUtils.toString(label));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ResolvedTradeParameterMetadata}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code trade} property.
     */
    private final MetaProperty<ResolvedTrade> trade = DirectMetaProperty.ofImmutable(
        this, "trade", ResolvedTradeParameterMetadata.class, ResolvedTrade.class);
    /**
     * The meta-property for the {@code label} property.
     */
    private final MetaProperty<String> label = DirectMetaProperty.ofImmutable(
        this, "label", ResolvedTradeParameterMetadata.class, String.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "trade",
        "label");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 110621028:  // trade
          return trade;
        case 102727412:  // label
          return label;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ResolvedTradeParameterMetadata.Builder builder() {
      return new ResolvedTradeParameterMetadata.Builder();
    }

    @Override
    public Class<? extends ResolvedTradeParameterMetadata> beanType() {
      return ResolvedTradeParameterMetadata.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code trade} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ResolvedTrade> trade() {
      return trade;
    }

    /**
     * The meta-property for the {@code label} property.
     * @return the meta-property, not null
     */
    public MetaProperty<String> label() {
      return label;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 110621028:  // trade
          return ((ResolvedTradeParameterMetadata) bean).getTrade();
        case 102727412:  // label
          return ((ResolvedTradeParameterMetadata) bean).getLabel();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code ResolvedTradeParameterMetadata}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ResolvedTradeParameterMetadata> {

    private ResolvedTrade trade;
    private String label;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ResolvedTradeParameterMetadata beanToCopy) {
      this.trade = beanToCopy.getTrade();
      this.label = beanToCopy.getLabel();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 110621028:  // trade
          return trade;
        case 102727412:  // label
          return label;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 110621028:  // trade
          this.trade = (ResolvedTrade) newValue;
          break;
        case 102727412:  // label
          this.label = (String) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public ResolvedTradeParameterMetadata build() {
      return new ResolvedTradeParameterMetadata(
          trade,
          label);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the trade that describes the parameter.
     * @param trade  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder trade(ResolvedTrade trade) {
      JodaBeanUtils.notNull(trade, "trade");
      this.trade = trade;
      return this;
    }

    /**
     * Sets the label that describes the parameter.
     * @param label  the new value, not empty
     * @return this, for chaining, not null
     */
    public Builder label(String label) {
      JodaBeanUtils.notEmpty(label, "label");
      this.label = label;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("ResolvedTradeParameterMetadata.Builder{");
      buf.append("trade").append('=').append(JodaBeanUtils.toString(trade)).append(',').append(' ');
      buf.append("label").append('=').append(JodaBeanUtils.toString(label));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
