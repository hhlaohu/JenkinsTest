package com.yiya.bean;

import java.util.ArrayList;
import java.util.List;

public class TabOrderBondsmaninfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabOrderBondsmaninfExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idIsNull() {
            addCriterion("usr_order_id is null");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idIsNotNull() {
            addCriterion("usr_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idEqualTo(Long value) {
            addCriterion("usr_order_id =", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idNotEqualTo(Long value) {
            addCriterion("usr_order_id <>", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idGreaterThan(Long value) {
            addCriterion("usr_order_id >", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idGreaterThanOrEqualTo(Long value) {
            addCriterion("usr_order_id >=", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idLessThan(Long value) {
            addCriterion("usr_order_id <", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idLessThanOrEqualTo(Long value) {
            addCriterion("usr_order_id <=", value, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idIn(List<Long> values) {
            addCriterion("usr_order_id in", values, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idNotIn(List<Long> values) {
            addCriterion("usr_order_id not in", values, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idBetween(Long value1, Long value2) {
            addCriterion("usr_order_id between", value1, value2, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andUsr_order_idNotBetween(Long value1, Long value2) {
            addCriterion("usr_order_id not between", value1, value2, "usr_order_id");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameIsNull() {
            addCriterion("rel_usrname is null");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameIsNotNull() {
            addCriterion("rel_usrname is not null");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameEqualTo(String value) {
            addCriterion("rel_usrname =", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameNotEqualTo(String value) {
            addCriterion("rel_usrname <>", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameGreaterThan(String value) {
            addCriterion("rel_usrname >", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameGreaterThanOrEqualTo(String value) {
            addCriterion("rel_usrname >=", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameLessThan(String value) {
            addCriterion("rel_usrname <", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameLessThanOrEqualTo(String value) {
            addCriterion("rel_usrname <=", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameLike(String value) {
            addCriterion("rel_usrname like", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameNotLike(String value) {
            addCriterion("rel_usrname not like", value, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameIn(List<String> values) {
            addCriterion("rel_usrname in", values, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameNotIn(List<String> values) {
            addCriterion("rel_usrname not in", values, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameBetween(String value1, String value2) {
            addCriterion("rel_usrname between", value1, value2, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRel_usrnameNotBetween(String value1, String value2) {
            addCriterion("rel_usrname not between", value1, value2, "rel_usrname");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(Integer value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(Integer value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(Integer value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(Integer value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(Integer value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<Integer> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<Integer> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(Integer value1, Integer value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(Integer value1, Integer value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneIsNull() {
            addCriterion("rel_mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneIsNotNull() {
            addCriterion("rel_mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneEqualTo(String value) {
            addCriterion("rel_mobile_phone =", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneNotEqualTo(String value) {
            addCriterion("rel_mobile_phone <>", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneGreaterThan(String value) {
            addCriterion("rel_mobile_phone >", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("rel_mobile_phone >=", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneLessThan(String value) {
            addCriterion("rel_mobile_phone <", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneLessThanOrEqualTo(String value) {
            addCriterion("rel_mobile_phone <=", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneLike(String value) {
            addCriterion("rel_mobile_phone like", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneNotLike(String value) {
            addCriterion("rel_mobile_phone not like", value, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneIn(List<String> values) {
            addCriterion("rel_mobile_phone in", values, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneNotIn(List<String> values) {
            addCriterion("rel_mobile_phone not in", values, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneBetween(String value1, String value2) {
            addCriterion("rel_mobile_phone between", value1, value2, "rel_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andRel_mobile_phoneNotBetween(String value1, String value2) {
            addCriterion("rel_mobile_phone not between", value1, value2, "rel_mobile_phone");
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