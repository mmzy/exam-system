package com.exam.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherClassesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherClassesExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassesidIsNull() {
            addCriterion("classesId is null");
            return (Criteria) this;
        }

        public Criteria andClassesidIsNotNull() {
            addCriterion("classesId is not null");
            return (Criteria) this;
        }

        public Criteria andClassesidEqualTo(Integer value) {
            addCriterion("classesId =", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotEqualTo(Integer value) {
            addCriterion("classesId <>", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidGreaterThan(Integer value) {
            addCriterion("classesId >", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classesId >=", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidLessThan(Integer value) {
            addCriterion("classesId <", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidLessThanOrEqualTo(Integer value) {
            addCriterion("classesId <=", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidIn(List<Integer> values) {
            addCriterion("classesId in", values, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotIn(List<Integer> values) {
            addCriterion("classesId not in", values, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidBetween(Integer value1, Integer value2) {
            addCriterion("classesId between", value1, value2, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotBetween(Integer value1, Integer value2) {
            addCriterion("classesId not between", value1, value2, "classesid");
            return (Criteria) this;
        }

        public Criteria andSubidIsNull() {
            addCriterion("subId is null");
            return (Criteria) this;
        }

        public Criteria andSubidIsNotNull() {
            addCriterion("subId is not null");
            return (Criteria) this;
        }

        public Criteria andSubidEqualTo(Integer value) {
            addCriterion("subId =", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidNotEqualTo(Integer value) {
            addCriterion("subId <>", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidGreaterThan(Integer value) {
            addCriterion("subId >", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidGreaterThanOrEqualTo(Integer value) {
            addCriterion("subId >=", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidLessThan(Integer value) {
            addCriterion("subId <", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidLessThanOrEqualTo(Integer value) {
            addCriterion("subId <=", value, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidIn(List<Integer> values) {
            addCriterion("subId in", values, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidNotIn(List<Integer> values) {
            addCriterion("subId not in", values, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidBetween(Integer value1, Integer value2) {
            addCriterion("subId between", value1, value2, "subid");
            return (Criteria) this;
        }

        public Criteria andSubidNotBetween(Integer value1, Integer value2) {
            addCriterion("subId not between", value1, value2, "subid");
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