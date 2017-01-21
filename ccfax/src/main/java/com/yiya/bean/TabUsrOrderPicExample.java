package com.yiya.bean;

import java.util.ArrayList;
import java.util.List;

public class TabUsrOrderPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabUsrOrderPicExample() {
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

        public Criteria andPic_descIsNull() {
            addCriterion("pic_desc is null");
            return (Criteria) this;
        }

        public Criteria andPic_descIsNotNull() {
            addCriterion("pic_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPic_descEqualTo(String value) {
            addCriterion("pic_desc =", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descNotEqualTo(String value) {
            addCriterion("pic_desc <>", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descGreaterThan(String value) {
            addCriterion("pic_desc >", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descGreaterThanOrEqualTo(String value) {
            addCriterion("pic_desc >=", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descLessThan(String value) {
            addCriterion("pic_desc <", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descLessThanOrEqualTo(String value) {
            addCriterion("pic_desc <=", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descLike(String value) {
            addCriterion("pic_desc like", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descNotLike(String value) {
            addCriterion("pic_desc not like", value, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descIn(List<String> values) {
            addCriterion("pic_desc in", values, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descNotIn(List<String> values) {
            addCriterion("pic_desc not in", values, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descBetween(String value1, String value2) {
            addCriterion("pic_desc between", value1, value2, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_descNotBetween(String value1, String value2) {
            addCriterion("pic_desc not between", value1, value2, "pic_desc");
            return (Criteria) this;
        }

        public Criteria andPic_addrIsNull() {
            addCriterion("pic_addr is null");
            return (Criteria) this;
        }

        public Criteria andPic_addrIsNotNull() {
            addCriterion("pic_addr is not null");
            return (Criteria) this;
        }

        public Criteria andPic_addrEqualTo(String value) {
            addCriterion("pic_addr =", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrNotEqualTo(String value) {
            addCriterion("pic_addr <>", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrGreaterThan(String value) {
            addCriterion("pic_addr >", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrGreaterThanOrEqualTo(String value) {
            addCriterion("pic_addr >=", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrLessThan(String value) {
            addCriterion("pic_addr <", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrLessThanOrEqualTo(String value) {
            addCriterion("pic_addr <=", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrLike(String value) {
            addCriterion("pic_addr like", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrNotLike(String value) {
            addCriterion("pic_addr not like", value, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrIn(List<String> values) {
            addCriterion("pic_addr in", values, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrNotIn(List<String> values) {
            addCriterion("pic_addr not in", values, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrBetween(String value1, String value2) {
            addCriterion("pic_addr between", value1, value2, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andPic_addrNotBetween(String value1, String value2) {
            addCriterion("pic_addr not between", value1, value2, "pic_addr");
            return (Criteria) this;
        }

        public Criteria andOrder_snIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrder_snIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_snEqualTo(String value) {
            addCriterion("order_sn =", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snGreaterThan(String value) {
            addCriterion("order_sn >", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLessThan(String value) {
            addCriterion("order_sn <", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snLike(String value) {
            addCriterion("order_sn like", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotLike(String value) {
            addCriterion("order_sn not like", value, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snIn(List<String> values) {
            addCriterion("order_sn in", values, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "order_sn");
            return (Criteria) this;
        }

        public Criteria andOrder_snNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "order_sn");
            return (Criteria) this;
        }

        public Criteria andIs_codeIsNull() {
            addCriterion("is_code is null");
            return (Criteria) this;
        }

        public Criteria andIs_codeIsNotNull() {
            addCriterion("is_code is not null");
            return (Criteria) this;
        }

        public Criteria andIs_codeEqualTo(Byte value) {
            addCriterion("is_code =", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeNotEqualTo(Byte value) {
            addCriterion("is_code <>", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeGreaterThan(Byte value) {
            addCriterion("is_code >", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_code >=", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeLessThan(Byte value) {
            addCriterion("is_code <", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeLessThanOrEqualTo(Byte value) {
            addCriterion("is_code <=", value, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeIn(List<Byte> values) {
            addCriterion("is_code in", values, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeNotIn(List<Byte> values) {
            addCriterion("is_code not in", values, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeBetween(Byte value1, Byte value2) {
            addCriterion("is_code between", value1, value2, "is_code");
            return (Criteria) this;
        }

        public Criteria andIs_codeNotBetween(Byte value1, Byte value2) {
            addCriterion("is_code not between", value1, value2, "is_code");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Byte value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Byte value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Byte value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Byte value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Byte value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Byte value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Byte> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Byte> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Byte value1, Byte value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Byte value1, Byte value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andPic_typeIsNull() {
            addCriterion("pic_type is null");
            return (Criteria) this;
        }

        public Criteria andPic_typeIsNotNull() {
            addCriterion("pic_type is not null");
            return (Criteria) this;
        }

        public Criteria andPic_typeEqualTo(Byte value) {
            addCriterion("pic_type =", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeNotEqualTo(Byte value) {
            addCriterion("pic_type <>", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeGreaterThan(Byte value) {
            addCriterion("pic_type >", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("pic_type >=", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeLessThan(Byte value) {
            addCriterion("pic_type <", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeLessThanOrEqualTo(Byte value) {
            addCriterion("pic_type <=", value, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeIn(List<Byte> values) {
            addCriterion("pic_type in", values, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeNotIn(List<Byte> values) {
            addCriterion("pic_type not in", values, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeBetween(Byte value1, Byte value2) {
            addCriterion("pic_type between", value1, value2, "pic_type");
            return (Criteria) this;
        }

        public Criteria andPic_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("pic_type not between", value1, value2, "pic_type");
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