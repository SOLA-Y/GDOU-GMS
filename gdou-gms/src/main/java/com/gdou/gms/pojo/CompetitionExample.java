package com.gdou.gms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompetitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompetitionExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andCompetidIsNull() {
            addCriterion("competId is null");
            return (Criteria) this;
        }

        public Criteria andCompetidIsNotNull() {
            addCriterion("competId is not null");
            return (Criteria) this;
        }

        public Criteria andCompetidEqualTo(String value) {
            addCriterion("competId =", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidNotEqualTo(String value) {
            addCriterion("competId <>", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidGreaterThan(String value) {
            addCriterion("competId >", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidGreaterThanOrEqualTo(String value) {
            addCriterion("competId >=", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidLessThan(String value) {
            addCriterion("competId <", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidLessThanOrEqualTo(String value) {
            addCriterion("competId <=", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidLike(String value) {
            addCriterion("competId like", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidNotLike(String value) {
            addCriterion("competId not like", value, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidIn(List<String> values) {
            addCriterion("competId in", values, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidNotIn(List<String> values) {
            addCriterion("competId not in", values, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidBetween(String value1, String value2) {
            addCriterion("competId between", value1, value2, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetidNotBetween(String value1, String value2) {
            addCriterion("competId not between", value1, value2, "competid");
            return (Criteria) this;
        }

        public Criteria andCompetNameIsNull() {
            addCriterion("compet_name is null");
            return (Criteria) this;
        }

        public Criteria andCompetNameIsNotNull() {
            addCriterion("compet_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompetNameEqualTo(String value) {
            addCriterion("compet_name =", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameNotEqualTo(String value) {
            addCriterion("compet_name <>", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameGreaterThan(String value) {
            addCriterion("compet_name >", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameGreaterThanOrEqualTo(String value) {
            addCriterion("compet_name >=", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameLessThan(String value) {
            addCriterion("compet_name <", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameLessThanOrEqualTo(String value) {
            addCriterion("compet_name <=", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameLike(String value) {
            addCriterion("compet_name like", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameNotLike(String value) {
            addCriterion("compet_name not like", value, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameIn(List<String> values) {
            addCriterion("compet_name in", values, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameNotIn(List<String> values) {
            addCriterion("compet_name not in", values, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameBetween(String value1, String value2) {
            addCriterion("compet_name between", value1, value2, "competName");
            return (Criteria) this;
        }

        public Criteria andCompetNameNotBetween(String value1, String value2) {
            addCriterion("compet_name not between", value1, value2, "competName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSiteidIsNull() {
            addCriterion("siteId is null");
            return (Criteria) this;
        }

        public Criteria andSiteidIsNotNull() {
            addCriterion("siteId is not null");
            return (Criteria) this;
        }

        public Criteria andSiteidEqualTo(Integer value) {
            addCriterion("siteId =", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotEqualTo(Integer value) {
            addCriterion("siteId <>", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidGreaterThan(Integer value) {
            addCriterion("siteId >", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("siteId >=", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidLessThan(Integer value) {
            addCriterion("siteId <", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidLessThanOrEqualTo(Integer value) {
            addCriterion("siteId <=", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidIn(List<Integer> values) {
            addCriterion("siteId in", values, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotIn(List<Integer> values) {
            addCriterion("siteId not in", values, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidBetween(Integer value1, Integer value2) {
            addCriterion("siteId between", value1, value2, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotBetween(Integer value1, Integer value2) {
            addCriterion("siteId not between", value1, value2, "siteid");
            return (Criteria) this;
        }

        public Criteria andEquidIsNull() {
            addCriterion("equId is null");
            return (Criteria) this;
        }

        public Criteria andEquidIsNotNull() {
            addCriterion("equId is not null");
            return (Criteria) this;
        }

        public Criteria andEquidEqualTo(Integer value) {
            addCriterion("equId =", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotEqualTo(Integer value) {
            addCriterion("equId <>", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidGreaterThan(Integer value) {
            addCriterion("equId >", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidGreaterThanOrEqualTo(Integer value) {
            addCriterion("equId >=", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidLessThan(Integer value) {
            addCriterion("equId <", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidLessThanOrEqualTo(Integer value) {
            addCriterion("equId <=", value, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidIn(List<Integer> values) {
            addCriterion("equId in", values, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotIn(List<Integer> values) {
            addCriterion("equId not in", values, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidBetween(Integer value1, Integer value2) {
            addCriterion("equId between", value1, value2, "equid");
            return (Criteria) this;
        }

        public Criteria andEquidNotBetween(Integer value1, Integer value2) {
            addCriterion("equId not between", value1, value2, "equid");
            return (Criteria) this;
        }

        public Criteria andSorderIdIsNull() {
            addCriterion("sorder_id is null");
            return (Criteria) this;
        }

        public Criteria andSorderIdIsNotNull() {
            addCriterion("sorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andSorderIdEqualTo(Integer value) {
            addCriterion("sorder_id =", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdNotEqualTo(Integer value) {
            addCriterion("sorder_id <>", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdGreaterThan(Integer value) {
            addCriterion("sorder_id >", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sorder_id >=", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdLessThan(Integer value) {
            addCriterion("sorder_id <", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdLessThanOrEqualTo(Integer value) {
            addCriterion("sorder_id <=", value, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdIn(List<Integer> values) {
            addCriterion("sorder_id in", values, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdNotIn(List<Integer> values) {
            addCriterion("sorder_id not in", values, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdBetween(Integer value1, Integer value2) {
            addCriterion("sorder_id between", value1, value2, "sorderId");
            return (Criteria) this;
        }

        public Criteria andSorderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sorder_id not between", value1, value2, "sorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdIsNull() {
            addCriterion("eorder_id is null");
            return (Criteria) this;
        }

        public Criteria andEorderIdIsNotNull() {
            addCriterion("eorder_id is not null");
            return (Criteria) this;
        }

        public Criteria andEorderIdEqualTo(Integer value) {
            addCriterion("eorder_id =", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdNotEqualTo(Integer value) {
            addCriterion("eorder_id <>", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdGreaterThan(Integer value) {
            addCriterion("eorder_id >", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eorder_id >=", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdLessThan(Integer value) {
            addCriterion("eorder_id <", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdLessThanOrEqualTo(Integer value) {
            addCriterion("eorder_id <=", value, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdIn(List<Integer> values) {
            addCriterion("eorder_id in", values, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdNotIn(List<Integer> values) {
            addCriterion("eorder_id not in", values, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdBetween(Integer value1, Integer value2) {
            addCriterion("eorder_id between", value1, value2, "eorderId");
            return (Criteria) this;
        }

        public Criteria andEorderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eorder_id not between", value1, value2, "eorderId");
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