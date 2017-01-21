package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabBorrowSerialCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabBorrowSerialCodeExample() {
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

        public Criteria andBorrow_typeIsNull() {
            addCriterion("borrow_type is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeIsNotNull() {
            addCriterion("borrow_type is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeEqualTo(Byte value) {
            addCriterion("borrow_type =", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeNotEqualTo(Byte value) {
            addCriterion("borrow_type <>", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeGreaterThan(Byte value) {
            addCriterion("borrow_type >", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("borrow_type >=", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeLessThan(Byte value) {
            addCriterion("borrow_type <", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeLessThanOrEqualTo(Byte value) {
            addCriterion("borrow_type <=", value, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeIn(List<Byte> values) {
            addCriterion("borrow_type in", values, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeNotIn(List<Byte> values) {
            addCriterion("borrow_type not in", values, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeBetween(Byte value1, Byte value2) {
            addCriterion("borrow_type between", value1, value2, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("borrow_type not between", value1, value2, "borrow_type");
            return (Criteria) this;
        }

        public Criteria andSerial_codeIsNull() {
            addCriterion("serial_code is null");
            return (Criteria) this;
        }

        public Criteria andSerial_codeIsNotNull() {
            addCriterion("serial_code is not null");
            return (Criteria) this;
        }

        public Criteria andSerial_codeEqualTo(Integer value) {
            addCriterion("serial_code =", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeNotEqualTo(Integer value) {
            addCriterion("serial_code <>", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeGreaterThan(Integer value) {
            addCriterion("serial_code >", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_code >=", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeLessThan(Integer value) {
            addCriterion("serial_code <", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeLessThanOrEqualTo(Integer value) {
            addCriterion("serial_code <=", value, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeIn(List<Integer> values) {
            addCriterion("serial_code in", values, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeNotIn(List<Integer> values) {
            addCriterion("serial_code not in", values, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeBetween(Integer value1, Integer value2) {
            addCriterion("serial_code between", value1, value2, "serial_code");
            return (Criteria) this;
        }

        public Criteria andSerial_codeNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_code not between", value1, value2, "serial_code");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
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