package cn.edu.ncu.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopicExample() {
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

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Integer value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Integer value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Integer value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Integer value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Integer> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Integer> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andBrowseIsNull() {
            addCriterion("browse is null");
            return (Criteria) this;
        }

        public Criteria andBrowseIsNotNull() {
            addCriterion("browse is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseEqualTo(Integer value) {
            addCriterion("browse =", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotEqualTo(Integer value) {
            addCriterion("browse <>", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseGreaterThan(Integer value) {
            addCriterion("browse >", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse >=", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseLessThan(Integer value) {
            addCriterion("browse <", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseLessThanOrEqualTo(Integer value) {
            addCriterion("browse <=", value, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseIn(List<Integer> values) {
            addCriterion("browse in", values, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotIn(List<Integer> values) {
            addCriterion("browse not in", values, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseBetween(Integer value1, Integer value2) {
            addCriterion("browse between", value1, value2, "browse");
            return (Criteria) this;
        }

        public Criteria andBrowseNotBetween(Integer value1, Integer value2) {
            addCriterion("browse not between", value1, value2, "browse");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andHelpIsNull() {
            addCriterion("help is null");
            return (Criteria) this;
        }

        public Criteria andHelpIsNotNull() {
            addCriterion("help is not null");
            return (Criteria) this;
        }

        public Criteria andHelpEqualTo(Boolean value) {
            addCriterion("help =", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpNotEqualTo(Boolean value) {
            addCriterion("help <>", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpGreaterThan(Boolean value) {
            addCriterion("help >", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("help >=", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpLessThan(Boolean value) {
            addCriterion("help <", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpLessThanOrEqualTo(Boolean value) {
            addCriterion("help <=", value, "help");
            return (Criteria) this;
        }

        public Criteria andHelpIn(List<Boolean> values) {
            addCriterion("help in", values, "help");
            return (Criteria) this;
        }

        public Criteria andHelpNotIn(List<Boolean> values) {
            addCriterion("help not in", values, "help");
            return (Criteria) this;
        }

        public Criteria andHelpBetween(Boolean value1, Boolean value2) {
            addCriterion("help between", value1, value2, "help");
            return (Criteria) this;
        }

        public Criteria andHelpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("help not between", value1, value2, "help");
            return (Criteria) this;
        }

        public Criteria andEliteIsNull() {
            addCriterion("elite is null");
            return (Criteria) this;
        }

        public Criteria andEliteIsNotNull() {
            addCriterion("elite is not null");
            return (Criteria) this;
        }

        public Criteria andEliteEqualTo(Boolean value) {
            addCriterion("elite =", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteNotEqualTo(Boolean value) {
            addCriterion("elite <>", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteGreaterThan(Boolean value) {
            addCriterion("elite >", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("elite >=", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteLessThan(Boolean value) {
            addCriterion("elite <", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteLessThanOrEqualTo(Boolean value) {
            addCriterion("elite <=", value, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteIn(List<Boolean> values) {
            addCriterion("elite in", values, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteNotIn(List<Boolean> values) {
            addCriterion("elite not in", values, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteBetween(Boolean value1, Boolean value2) {
            addCriterion("elite between", value1, value2, "elite");
            return (Criteria) this;
        }

        public Criteria andEliteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("elite not between", value1, value2, "elite");
            return (Criteria) this;
        }

        public Criteria andOnPageTopIsNull() {
            addCriterion("on_page_top is null");
            return (Criteria) this;
        }

        public Criteria andOnPageTopIsNotNull() {
            addCriterion("on_page_top is not null");
            return (Criteria) this;
        }

        public Criteria andOnPageTopEqualTo(Boolean value) {
            addCriterion("on_page_top =", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopNotEqualTo(Boolean value) {
            addCriterion("on_page_top <>", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopGreaterThan(Boolean value) {
            addCriterion("on_page_top >", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("on_page_top >=", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopLessThan(Boolean value) {
            addCriterion("on_page_top <", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopLessThanOrEqualTo(Boolean value) {
            addCriterion("on_page_top <=", value, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopIn(List<Boolean> values) {
            addCriterion("on_page_top in", values, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopNotIn(List<Boolean> values) {
            addCriterion("on_page_top not in", values, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopBetween(Boolean value1, Boolean value2) {
            addCriterion("on_page_top between", value1, value2, "onPageTop");
            return (Criteria) this;
        }

        public Criteria andOnPageTopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("on_page_top not between", value1, value2, "onPageTop");
            return (Criteria) this;
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

        public Criteria andAdoptIdIsNull() {
            addCriterion("adopt_id is null");
            return (Criteria) this;
        }

        public Criteria andAdoptIdIsNotNull() {
            addCriterion("adopt_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptIdEqualTo(Integer value) {
            addCriterion("adopt_id =", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotEqualTo(Integer value) {
            addCriterion("adopt_id <>", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdGreaterThan(Integer value) {
            addCriterion("adopt_id >", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adopt_id >=", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdLessThan(Integer value) {
            addCriterion("adopt_id <", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdLessThanOrEqualTo(Integer value) {
            addCriterion("adopt_id <=", value, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdIn(List<Integer> values) {
            addCriterion("adopt_id in", values, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotIn(List<Integer> values) {
            addCriterion("adopt_id not in", values, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdBetween(Integer value1, Integer value2) {
            addCriterion("adopt_id between", value1, value2, "adoptId");
            return (Criteria) this;
        }

        public Criteria andAdoptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adopt_id not between", value1, value2, "adoptId");
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