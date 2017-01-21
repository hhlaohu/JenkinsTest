package com.yiya.bean;

import java.util.ArrayList;
import java.util.List;

public class TabBlacklistReportListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabBlacklistReportListExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReport_idIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReport_idIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReport_idEqualTo(Integer value) {
            addCriterion("report_id =", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotEqualTo(Integer value) {
            addCriterion("report_id <>", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idGreaterThan(Integer value) {
            addCriterion("report_id >", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_id >=", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idLessThan(Integer value) {
            addCriterion("report_id <", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idLessThanOrEqualTo(Integer value) {
            addCriterion("report_id <=", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idIn(List<Integer> values) {
            addCriterion("report_id in", values, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotIn(List<Integer> values) {
            addCriterion("report_id not in", values, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idBetween(Integer value1, Integer value2) {
            addCriterion("report_id between", value1, value2, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotBetween(Integer value1, Integer value2) {
            addCriterion("report_id not between", value1, value2, "report_id");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeIsNull() {
            addCriterion("blacklist_type is null");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeIsNotNull() {
            addCriterion("blacklist_type is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeEqualTo(String value) {
            addCriterion("blacklist_type =", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeNotEqualTo(String value) {
            addCriterion("blacklist_type <>", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeGreaterThan(String value) {
            addCriterion("blacklist_type >", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeGreaterThanOrEqualTo(String value) {
            addCriterion("blacklist_type >=", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeLessThan(String value) {
            addCriterion("blacklist_type <", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeLessThanOrEqualTo(String value) {
            addCriterion("blacklist_type <=", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeLike(String value) {
            addCriterion("blacklist_type like", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeNotLike(String value) {
            addCriterion("blacklist_type not like", value, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeIn(List<String> values) {
            addCriterion("blacklist_type in", values, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeNotIn(List<String> values) {
            addCriterion("blacklist_type not in", values, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeBetween(String value1, String value2) {
            addCriterion("blacklist_type between", value1, value2, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_typeNotBetween(String value1, String value2) {
            addCriterion("blacklist_type not between", value1, value2, "blacklist_type");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueIsNull() {
            addCriterion("blacklist_value is null");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueIsNotNull() {
            addCriterion("blacklist_value is not null");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueEqualTo(String value) {
            addCriterion("blacklist_value =", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueNotEqualTo(String value) {
            addCriterion("blacklist_value <>", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueGreaterThan(String value) {
            addCriterion("blacklist_value >", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueGreaterThanOrEqualTo(String value) {
            addCriterion("blacklist_value >=", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueLessThan(String value) {
            addCriterion("blacklist_value <", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueLessThanOrEqualTo(String value) {
            addCriterion("blacklist_value <=", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueLike(String value) {
            addCriterion("blacklist_value like", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueNotLike(String value) {
            addCriterion("blacklist_value not like", value, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueIn(List<String> values) {
            addCriterion("blacklist_value in", values, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueNotIn(List<String> values) {
            addCriterion("blacklist_value not in", values, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueBetween(String value1, String value2) {
            addCriterion("blacklist_value between", value1, value2, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andBlacklist_valueNotBetween(String value1, String value2) {
            addCriterion("blacklist_value not between", value1, value2, "blacklist_value");
            return (Criteria) this;
        }

        public Criteria andIs_hitIsNull() {
            addCriterion("is_hit is null");
            return (Criteria) this;
        }

        public Criteria andIs_hitIsNotNull() {
            addCriterion("is_hit is not null");
            return (Criteria) this;
        }

        public Criteria andIs_hitEqualTo(Byte value) {
            addCriterion("is_hit =", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitNotEqualTo(Byte value) {
            addCriterion("is_hit <>", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitGreaterThan(Byte value) {
            addCriterion("is_hit >", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_hit >=", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitLessThan(Byte value) {
            addCriterion("is_hit <", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitLessThanOrEqualTo(Byte value) {
            addCriterion("is_hit <=", value, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitIn(List<Byte> values) {
            addCriterion("is_hit in", values, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitNotIn(List<Byte> values) {
            addCriterion("is_hit not in", values, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitBetween(Byte value1, Byte value2) {
            addCriterion("is_hit between", value1, value2, "is_hit");
            return (Criteria) this;
        }

        public Criteria andIs_hitNotBetween(Byte value1, Byte value2) {
            addCriterion("is_hit not between", value1, value2, "is_hit");
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