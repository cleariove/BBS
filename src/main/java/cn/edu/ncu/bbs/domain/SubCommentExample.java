package cn.edu.ncu.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubCommentExample() {
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

        public Criteria andSubCommentIdIsNull() {
            addCriterion("sub_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdIsNotNull() {
            addCriterion("sub_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdEqualTo(Integer value) {
            addCriterion("sub_comment_id =", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdNotEqualTo(Integer value) {
            addCriterion("sub_comment_id <>", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdGreaterThan(Integer value) {
            addCriterion("sub_comment_id >", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_id >=", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdLessThan(Integer value) {
            addCriterion("sub_comment_id <", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_id <=", value, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdIn(List<Integer> values) {
            addCriterion("sub_comment_id in", values, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdNotIn(List<Integer> values) {
            addCriterion("sub_comment_id not in", values, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_id between", value1, value2, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_id not between", value1, value2, "subCommentId");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromIsNull() {
            addCriterion("sub_comment_from is null");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromIsNotNull() {
            addCriterion("sub_comment_from is not null");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromEqualTo(Integer value) {
            addCriterion("sub_comment_from =", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromNotEqualTo(Integer value) {
            addCriterion("sub_comment_from <>", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromGreaterThan(Integer value) {
            addCriterion("sub_comment_from >", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_from >=", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromLessThan(Integer value) {
            addCriterion("sub_comment_from <", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromLessThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_from <=", value, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromIn(List<Integer> values) {
            addCriterion("sub_comment_from in", values, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromNotIn(List<Integer> values) {
            addCriterion("sub_comment_from not in", values, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_from between", value1, value2, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentFromNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_from not between", value1, value2, "subCommentFrom");
            return (Criteria) this;
        }

        public Criteria andSubCommentToIsNull() {
            addCriterion("sub_comment_to is null");
            return (Criteria) this;
        }

        public Criteria andSubCommentToIsNotNull() {
            addCriterion("sub_comment_to is not null");
            return (Criteria) this;
        }

        public Criteria andSubCommentToEqualTo(Integer value) {
            addCriterion("sub_comment_to =", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToNotEqualTo(Integer value) {
            addCriterion("sub_comment_to <>", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToGreaterThan(Integer value) {
            addCriterion("sub_comment_to >", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_to >=", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToLessThan(Integer value) {
            addCriterion("sub_comment_to <", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToLessThanOrEqualTo(Integer value) {
            addCriterion("sub_comment_to <=", value, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToIn(List<Integer> values) {
            addCriterion("sub_comment_to in", values, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToNotIn(List<Integer> values) {
            addCriterion("sub_comment_to not in", values, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_to between", value1, value2, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andSubCommentToNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_comment_to not between", value1, value2, "subCommentTo");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
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