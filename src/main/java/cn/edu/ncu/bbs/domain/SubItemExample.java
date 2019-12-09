package cn.edu.ncu.bbs.domain;

import java.util.ArrayList;
import java.util.List;

public class SubItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSubItemIdIsNull() {
            addCriterion("sub_item_id is null");
            return (Criteria) this;
        }

        public Criteria andSubItemIdIsNotNull() {
            addCriterion("sub_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubItemIdEqualTo(Integer value) {
            addCriterion("sub_item_id =", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdNotEqualTo(Integer value) {
            addCriterion("sub_item_id <>", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdGreaterThan(Integer value) {
            addCriterion("sub_item_id >", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_item_id >=", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdLessThan(Integer value) {
            addCriterion("sub_item_id <", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_item_id <=", value, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdIn(List<Integer> values) {
            addCriterion("sub_item_id in", values, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdNotIn(List<Integer> values) {
            addCriterion("sub_item_id not in", values, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_item_id between", value1, value2, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_item_id not between", value1, value2, "subItemId");
            return (Criteria) this;
        }

        public Criteria andSubItemNameIsNull() {
            addCriterion("sub_item_name is null");
            return (Criteria) this;
        }

        public Criteria andSubItemNameIsNotNull() {
            addCriterion("sub_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubItemNameEqualTo(String value) {
            addCriterion("sub_item_name =", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameNotEqualTo(String value) {
            addCriterion("sub_item_name <>", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameGreaterThan(String value) {
            addCriterion("sub_item_name >", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_item_name >=", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameLessThan(String value) {
            addCriterion("sub_item_name <", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameLessThanOrEqualTo(String value) {
            addCriterion("sub_item_name <=", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameLike(String value) {
            addCriterion("sub_item_name like", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameNotLike(String value) {
            addCriterion("sub_item_name not like", value, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameIn(List<String> values) {
            addCriterion("sub_item_name in", values, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameNotIn(List<String> values) {
            addCriterion("sub_item_name not in", values, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameBetween(String value1, String value2) {
            addCriterion("sub_item_name between", value1, value2, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemNameNotBetween(String value1, String value2) {
            addCriterion("sub_item_name not between", value1, value2, "subItemName");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionIsNull() {
            addCriterion("sub_item_description is null");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionIsNotNull() {
            addCriterion("sub_item_description is not null");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionEqualTo(String value) {
            addCriterion("sub_item_description =", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionNotEqualTo(String value) {
            addCriterion("sub_item_description <>", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionGreaterThan(String value) {
            addCriterion("sub_item_description >", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("sub_item_description >=", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionLessThan(String value) {
            addCriterion("sub_item_description <", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionLessThanOrEqualTo(String value) {
            addCriterion("sub_item_description <=", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionLike(String value) {
            addCriterion("sub_item_description like", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionNotLike(String value) {
            addCriterion("sub_item_description not like", value, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionIn(List<String> values) {
            addCriterion("sub_item_description in", values, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionNotIn(List<String> values) {
            addCriterion("sub_item_description not in", values, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionBetween(String value1, String value2) {
            addCriterion("sub_item_description between", value1, value2, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andSubItemDescriptionNotBetween(String value1, String value2) {
            addCriterion("sub_item_description not between", value1, value2, "subItemDescription");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(Integer value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(Integer value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(Integer value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(Integer value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(Integer value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<Integer> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<Integer> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(Integer value1, Integer value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}