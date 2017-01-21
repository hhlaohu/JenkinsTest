package com.yiya.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabUsrOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabUsrOrderExample() {
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

        public Criteria andOrder_typeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeEqualTo(Integer value) {
            addCriterion("order_type =", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThan(Integer value) {
            addCriterion("order_type <", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIn(List<Integer> values) {
            addCriterion("order_type in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyIsNull() {
            addCriterion("order_money is null");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyIsNotNull() {
            addCriterion("order_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyEqualTo(BigDecimal value) {
            addCriterion("order_money =", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyNotEqualTo(BigDecimal value) {
            addCriterion("order_money <>", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyGreaterThan(BigDecimal value) {
            addCriterion("order_money >", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_money >=", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyLessThan(BigDecimal value) {
            addCriterion("order_money <", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_money <=", value, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyIn(List<BigDecimal> values) {
            addCriterion("order_money in", values, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyNotIn(List<BigDecimal> values) {
            addCriterion("order_money not in", values, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_money between", value1, value2, "order_money");
            return (Criteria) this;
        }

        public Criteria andOrder_moneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_money not between", value1, value2, "order_money");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheck_timeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_timeEqualTo(Date value) {
            addCriterion("check_time =", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeGreaterThan(Date value) {
            addCriterion("check_time >", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeLessThan(Date value) {
            addCriterion("check_time <", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeIn(List<Date> values) {
            addCriterion("check_time in", values, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "check_time");
            return (Criteria) this;
        }

        public Criteria andCheck_timeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "check_time");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(Integer value) {
            addCriterion("order_status =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(Integer value) {
            addCriterion("order_status <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(Integer value) {
            addCriterion("order_status >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_status >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(Integer value) {
            addCriterion("order_status <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(Integer value) {
            addCriterion("order_status <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<Integer> values) {
            addCriterion("order_status in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<Integer> values) {
            addCriterion("order_status not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(Integer value1, Integer value2) {
            addCriterion("order_status between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_status not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameIsNull() {
            addCriterion("borrower_usrname is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameIsNotNull() {
            addCriterion("borrower_usrname is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameEqualTo(String value) {
            addCriterion("borrower_usrname =", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameNotEqualTo(String value) {
            addCriterion("borrower_usrname <>", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameGreaterThan(String value) {
            addCriterion("borrower_usrname >", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_usrname >=", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameLessThan(String value) {
            addCriterion("borrower_usrname <", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameLessThanOrEqualTo(String value) {
            addCriterion("borrower_usrname <=", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameLike(String value) {
            addCriterion("borrower_usrname like", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameNotLike(String value) {
            addCriterion("borrower_usrname not like", value, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameIn(List<String> values) {
            addCriterion("borrower_usrname in", values, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameNotIn(List<String> values) {
            addCriterion("borrower_usrname not in", values, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameBetween(String value1, String value2) {
            addCriterion("borrower_usrname between", value1, value2, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_usrnameNotBetween(String value1, String value2) {
            addCriterion("borrower_usrname not between", value1, value2, "borrower_usrname");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardIsNull() {
            addCriterion("borrower_id_card is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardIsNotNull() {
            addCriterion("borrower_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardEqualTo(String value) {
            addCriterion("borrower_id_card =", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardNotEqualTo(String value) {
            addCriterion("borrower_id_card <>", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardGreaterThan(String value) {
            addCriterion("borrower_id_card >", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_id_card >=", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardLessThan(String value) {
            addCriterion("borrower_id_card <", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardLessThanOrEqualTo(String value) {
            addCriterion("borrower_id_card <=", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardLike(String value) {
            addCriterion("borrower_id_card like", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardNotLike(String value) {
            addCriterion("borrower_id_card not like", value, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardIn(List<String> values) {
            addCriterion("borrower_id_card in", values, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardNotIn(List<String> values) {
            addCriterion("borrower_id_card not in", values, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardBetween(String value1, String value2) {
            addCriterion("borrower_id_card between", value1, value2, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andBorrower_id_cardNotBetween(String value1, String value2) {
            addCriterion("borrower_id_card not between", value1, value2, "borrower_id_card");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andMaritalIsNull() {
            addCriterion("marital is null");
            return (Criteria) this;
        }

        public Criteria andMaritalIsNotNull() {
            addCriterion("marital is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalEqualTo(Byte value) {
            addCriterion("marital =", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotEqualTo(Byte value) {
            addCriterion("marital <>", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThan(Byte value) {
            addCriterion("marital >", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThanOrEqualTo(Byte value) {
            addCriterion("marital >=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThan(Byte value) {
            addCriterion("marital <", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThanOrEqualTo(Byte value) {
            addCriterion("marital <=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalIn(List<Byte> values) {
            addCriterion("marital in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotIn(List<Byte> values) {
            addCriterion("marital not in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalBetween(Byte value1, Byte value2) {
            addCriterion("marital between", value1, value2, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotBetween(Byte value1, Byte value2) {
            addCriterion("marital not between", value1, value2, "marital");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_phoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobile_phone");
            return (Criteria) this;
        }

        public Criteria andDiplomaIsNull() {
            addCriterion("diploma is null");
            return (Criteria) this;
        }

        public Criteria andDiplomaIsNotNull() {
            addCriterion("diploma is not null");
            return (Criteria) this;
        }

        public Criteria andDiplomaEqualTo(Integer value) {
            addCriterion("diploma =", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotEqualTo(Integer value) {
            addCriterion("diploma <>", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThan(Integer value) {
            addCriterion("diploma >", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThanOrEqualTo(Integer value) {
            addCriterion("diploma >=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThan(Integer value) {
            addCriterion("diploma <", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThanOrEqualTo(Integer value) {
            addCriterion("diploma <=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaIn(List<Integer> values) {
            addCriterion("diploma in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotIn(List<Integer> values) {
            addCriterion("diploma not in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaBetween(Integer value1, Integer value2) {
            addCriterion("diploma between", value1, value2, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotBetween(Integer value1, Integer value2) {
            addCriterion("diploma not between", value1, value2, "diploma");
            return (Criteria) this;
        }

        public Criteria andRegister_placeIsNull() {
            addCriterion("register_place is null");
            return (Criteria) this;
        }

        public Criteria andRegister_placeIsNotNull() {
            addCriterion("register_place is not null");
            return (Criteria) this;
        }

        public Criteria andRegister_placeEqualTo(Integer value) {
            addCriterion("register_place =", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeNotEqualTo(Integer value) {
            addCriterion("register_place <>", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeGreaterThan(Integer value) {
            addCriterion("register_place >", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_place >=", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeLessThan(Integer value) {
            addCriterion("register_place <", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeLessThanOrEqualTo(Integer value) {
            addCriterion("register_place <=", value, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeIn(List<Integer> values) {
            addCriterion("register_place in", values, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeNotIn(List<Integer> values) {
            addCriterion("register_place not in", values, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeBetween(Integer value1, Integer value2) {
            addCriterion("register_place between", value1, value2, "register_place");
            return (Criteria) this;
        }

        public Criteria andRegister_placeNotBetween(Integer value1, Integer value2) {
            addCriterion("register_place not between", value1, value2, "register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeIsNull() {
            addCriterion("local_register_place is null");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeIsNotNull() {
            addCriterion("local_register_place is not null");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeEqualTo(Byte value) {
            addCriterion("local_register_place =", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotEqualTo(Byte value) {
            addCriterion("local_register_place <>", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeGreaterThan(Byte value) {
            addCriterion("local_register_place >", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeGreaterThanOrEqualTo(Byte value) {
            addCriterion("local_register_place >=", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeLessThan(Byte value) {
            addCriterion("local_register_place <", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeLessThanOrEqualTo(Byte value) {
            addCriterion("local_register_place <=", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeIn(List<Byte> values) {
            addCriterion("local_register_place in", values, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotIn(List<Byte> values) {
            addCriterion("local_register_place not in", values, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeBetween(Byte value1, Byte value2) {
            addCriterion("local_register_place between", value1, value2, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotBetween(Byte value1, Byte value2) {
            addCriterion("local_register_place not between", value1, value2, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNull() {
            addCriterion("bank_id is null");
            return (Criteria) this;
        }

        public Criteria andBank_idIsNotNull() {
            addCriterion("bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andBank_idEqualTo(String value) {
            addCriterion("bank_id =", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotEqualTo(String value) {
            addCriterion("bank_id <>", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThan(String value) {
            addCriterion("bank_id >", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idGreaterThanOrEqualTo(String value) {
            addCriterion("bank_id >=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThan(String value) {
            addCriterion("bank_id <", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLessThanOrEqualTo(String value) {
            addCriterion("bank_id <=", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idLike(String value) {
            addCriterion("bank_id like", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotLike(String value) {
            addCriterion("bank_id not like", value, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idIn(List<String> values) {
            addCriterion("bank_id in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotIn(List<String> values) {
            addCriterion("bank_id not in", values, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idBetween(String value1, String value2) {
            addCriterion("bank_id between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andBank_idNotBetween(String value1, String value2) {
            addCriterion("bank_id not between", value1, value2, "bank_id");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Integer value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Integer value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Integer value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Integer value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Integer value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Integer value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Integer> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Integer> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Integer value1, Integer value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Integer value1, Integer value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andHouse_typeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouse_typeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_typeEqualTo(Byte value) {
            addCriterion("house_type =", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotEqualTo(Byte value) {
            addCriterion("house_type <>", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeGreaterThan(Byte value) {
            addCriterion("house_type >", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("house_type >=", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeLessThan(Byte value) {
            addCriterion("house_type <", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeLessThanOrEqualTo(Byte value) {
            addCriterion("house_type <=", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeIn(List<Byte> values) {
            addCriterion("house_type in", values, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotIn(List<Byte> values) {
            addCriterion("house_type not in", values, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeBetween(Byte value1, Byte value2) {
            addCriterion("house_type between", value1, value2, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("house_type not between", value1, value2, "house_type");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsIsNull() {
            addCriterion("fixed_assets is null");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsIsNotNull() {
            addCriterion("fixed_assets is not null");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsEqualTo(Byte value) {
            addCriterion("fixed_assets =", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotEqualTo(Byte value) {
            addCriterion("fixed_assets <>", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsGreaterThan(Byte value) {
            addCriterion("fixed_assets >", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsGreaterThanOrEqualTo(Byte value) {
            addCriterion("fixed_assets >=", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsLessThan(Byte value) {
            addCriterion("fixed_assets <", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsLessThanOrEqualTo(Byte value) {
            addCriterion("fixed_assets <=", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsIn(List<Byte> values) {
            addCriterion("fixed_assets in", values, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotIn(List<Byte> values) {
            addCriterion("fixed_assets not in", values, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsBetween(Byte value1, Byte value2) {
            addCriterion("fixed_assets between", value1, value2, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotBetween(Byte value1, Byte value2) {
            addCriterion("fixed_assets not between", value1, value2, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andEmploymentIsNull() {
            addCriterion("employment is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentIsNotNull() {
            addCriterion("employment is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentEqualTo(Byte value) {
            addCriterion("employment =", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotEqualTo(Byte value) {
            addCriterion("employment <>", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThan(Byte value) {
            addCriterion("employment >", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThanOrEqualTo(Byte value) {
            addCriterion("employment >=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThan(Byte value) {
            addCriterion("employment <", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThanOrEqualTo(Byte value) {
            addCriterion("employment <=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentIn(List<Byte> values) {
            addCriterion("employment in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotIn(List<Byte> values) {
            addCriterion("employment not in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentBetween(Byte value1, Byte value2) {
            addCriterion("employment between", value1, value2, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotBetween(Byte value1, Byte value2) {
            addCriterion("employment not between", value1, value2, "employment");
            return (Criteria) this;
        }

        public Criteria andCom_nameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andCom_nameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andCom_nameEqualTo(String value) {
            addCriterion("com_name =", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameGreaterThan(String value) {
            addCriterion("com_name >", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameLessThan(String value) {
            addCriterion("com_name <", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameLike(String value) {
            addCriterion("com_name like", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameNotLike(String value) {
            addCriterion("com_name not like", value, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameIn(List<String> values) {
            addCriterion("com_name in", values, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "com_name");
            return (Criteria) this;
        }

        public Criteria andCom_nameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "com_name");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(Integer value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(Integer value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(Integer value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(Integer value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(Integer value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<Integer> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<Integer> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(Integer value1, Integer value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(Integer value1, Integer value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andProfession_levelIsNull() {
            addCriterion("profession_level is null");
            return (Criteria) this;
        }

        public Criteria andProfession_levelIsNotNull() {
            addCriterion("profession_level is not null");
            return (Criteria) this;
        }

        public Criteria andProfession_levelEqualTo(Integer value) {
            addCriterion("profession_level =", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotEqualTo(Integer value) {
            addCriterion("profession_level <>", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelGreaterThan(Integer value) {
            addCriterion("profession_level >", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelGreaterThanOrEqualTo(Integer value) {
            addCriterion("profession_level >=", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelLessThan(Integer value) {
            addCriterion("profession_level <", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelLessThanOrEqualTo(Integer value) {
            addCriterion("profession_level <=", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelIn(List<Integer> values) {
            addCriterion("profession_level in", values, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotIn(List<Integer> values) {
            addCriterion("profession_level not in", values, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelBetween(Integer value1, Integer value2) {
            addCriterion("profession_level between", value1, value2, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotBetween(Integer value1, Integer value2) {
            addCriterion("profession_level not between", value1, value2, "profession_level");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationIsNull() {
            addCriterion("cur_hire_duration is null");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationIsNotNull() {
            addCriterion("cur_hire_duration is not null");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationEqualTo(Integer value) {
            addCriterion("cur_hire_duration =", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotEqualTo(Integer value) {
            addCriterion("cur_hire_duration <>", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationGreaterThan(Integer value) {
            addCriterion("cur_hire_duration >", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_hire_duration >=", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationLessThan(Integer value) {
            addCriterion("cur_hire_duration <", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationLessThanOrEqualTo(Integer value) {
            addCriterion("cur_hire_duration <=", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationIn(List<Integer> values) {
            addCriterion("cur_hire_duration in", values, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotIn(List<Integer> values) {
            addCriterion("cur_hire_duration not in", values, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationBetween(Integer value1, Integer value2) {
            addCriterion("cur_hire_duration between", value1, value2, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_hire_duration not between", value1, value2, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemIsNull() {
            addCriterion("schooling_system is null");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemIsNotNull() {
            addCriterion("schooling_system is not null");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemEqualTo(Integer value) {
            addCriterion("schooling_system =", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotEqualTo(Integer value) {
            addCriterion("schooling_system <>", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemGreaterThan(Integer value) {
            addCriterion("schooling_system >", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemGreaterThanOrEqualTo(Integer value) {
            addCriterion("schooling_system >=", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemLessThan(Integer value) {
            addCriterion("schooling_system <", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemLessThanOrEqualTo(Integer value) {
            addCriterion("schooling_system <=", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemIn(List<Integer> values) {
            addCriterion("schooling_system in", values, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotIn(List<Integer> values) {
            addCriterion("schooling_system not in", values, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemBetween(Integer value1, Integer value2) {
            addCriterion("schooling_system between", value1, value2, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotBetween(Integer value1, Integer value2) {
            addCriterion("schooling_system not between", value1, value2, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolIsNull() {
            addCriterion("graduate_school is null");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolIsNotNull() {
            addCriterion("graduate_school is not null");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolEqualTo(String value) {
            addCriterion("graduate_school =", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolNotEqualTo(String value) {
            addCriterion("graduate_school <>", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolGreaterThan(String value) {
            addCriterion("graduate_school >", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_school >=", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolLessThan(String value) {
            addCriterion("graduate_school <", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolLessThanOrEqualTo(String value) {
            addCriterion("graduate_school <=", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolLike(String value) {
            addCriterion("graduate_school like", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolNotLike(String value) {
            addCriterion("graduate_school not like", value, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolIn(List<String> values) {
            addCriterion("graduate_school in", values, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolNotIn(List<String> values) {
            addCriterion("graduate_school not in", values, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolBetween(String value1, String value2) {
            addCriterion("graduate_school between", value1, value2, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andGraduate_schoolNotBetween(String value1, String value2) {
            addCriterion("graduate_school not between", value1, value2, "graduate_school");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceIsNull() {
            addCriterion("repaying_source is null");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceIsNotNull() {
            addCriterion("repaying_source is not null");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceEqualTo(String value) {
            addCriterion("repaying_source =", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceNotEqualTo(String value) {
            addCriterion("repaying_source <>", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceGreaterThan(String value) {
            addCriterion("repaying_source >", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceGreaterThanOrEqualTo(String value) {
            addCriterion("repaying_source >=", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceLessThan(String value) {
            addCriterion("repaying_source <", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceLessThanOrEqualTo(String value) {
            addCriterion("repaying_source <=", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceLike(String value) {
            addCriterion("repaying_source like", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceNotLike(String value) {
            addCriterion("repaying_source not like", value, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceIn(List<String> values) {
            addCriterion("repaying_source in", values, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceNotIn(List<String> values) {
            addCriterion("repaying_source not in", values, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceBetween(String value1, String value2) {
            addCriterion("repaying_source between", value1, value2, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andRepaying_sourceNotBetween(String value1, String value2) {
            addCriterion("repaying_source not between", value1, value2, "repaying_source");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picIsNull() {
            addCriterion("id_card_front_pic is null");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picIsNotNull() {
            addCriterion("id_card_front_pic is not null");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picEqualTo(String value) {
            addCriterion("id_card_front_pic =", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picNotEqualTo(String value) {
            addCriterion("id_card_front_pic <>", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picGreaterThan(String value) {
            addCriterion("id_card_front_pic >", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_front_pic >=", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picLessThan(String value) {
            addCriterion("id_card_front_pic <", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picLessThanOrEqualTo(String value) {
            addCriterion("id_card_front_pic <=", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picLike(String value) {
            addCriterion("id_card_front_pic like", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picNotLike(String value) {
            addCriterion("id_card_front_pic not like", value, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picIn(List<String> values) {
            addCriterion("id_card_front_pic in", values, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picNotIn(List<String> values) {
            addCriterion("id_card_front_pic not in", values, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picBetween(String value1, String value2) {
            addCriterion("id_card_front_pic between", value1, value2, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_front_picNotBetween(String value1, String value2) {
            addCriterion("id_card_front_pic not between", value1, value2, "id_card_front_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picIsNull() {
            addCriterion("id_card_reverse_pic is null");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picIsNotNull() {
            addCriterion("id_card_reverse_pic is not null");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picEqualTo(String value) {
            addCriterion("id_card_reverse_pic =", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picNotEqualTo(String value) {
            addCriterion("id_card_reverse_pic <>", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picGreaterThan(String value) {
            addCriterion("id_card_reverse_pic >", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_reverse_pic >=", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picLessThan(String value) {
            addCriterion("id_card_reverse_pic <", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picLessThanOrEqualTo(String value) {
            addCriterion("id_card_reverse_pic <=", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picLike(String value) {
            addCriterion("id_card_reverse_pic like", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picNotLike(String value) {
            addCriterion("id_card_reverse_pic not like", value, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picIn(List<String> values) {
            addCriterion("id_card_reverse_pic in", values, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picNotIn(List<String> values) {
            addCriterion("id_card_reverse_pic not in", values, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picBetween(String value1, String value2) {
            addCriterion("id_card_reverse_pic between", value1, value2, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andId_card_reverse_picNotBetween(String value1, String value2) {
            addCriterion("id_card_reverse_pic not between", value1, value2, "id_card_reverse_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picIsNull() {
            addCriterion("with_id_card_pic is null");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picIsNotNull() {
            addCriterion("with_id_card_pic is not null");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picEqualTo(String value) {
            addCriterion("with_id_card_pic =", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picNotEqualTo(String value) {
            addCriterion("with_id_card_pic <>", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picGreaterThan(String value) {
            addCriterion("with_id_card_pic >", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picGreaterThanOrEqualTo(String value) {
            addCriterion("with_id_card_pic >=", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picLessThan(String value) {
            addCriterion("with_id_card_pic <", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picLessThanOrEqualTo(String value) {
            addCriterion("with_id_card_pic <=", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picLike(String value) {
            addCriterion("with_id_card_pic like", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picNotLike(String value) {
            addCriterion("with_id_card_pic not like", value, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picIn(List<String> values) {
            addCriterion("with_id_card_pic in", values, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picNotIn(List<String> values) {
            addCriterion("with_id_card_pic not in", values, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picBetween(String value1, String value2) {
            addCriterion("with_id_card_pic between", value1, value2, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andWith_id_card_picNotBetween(String value1, String value2) {
            addCriterion("with_id_card_pic not between", value1, value2, "with_id_card_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picIsNull() {
            addCriterion("credit_report_pic is null");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picIsNotNull() {
            addCriterion("credit_report_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picEqualTo(String value) {
            addCriterion("credit_report_pic =", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picNotEqualTo(String value) {
            addCriterion("credit_report_pic <>", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picGreaterThan(String value) {
            addCriterion("credit_report_pic >", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picGreaterThanOrEqualTo(String value) {
            addCriterion("credit_report_pic >=", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picLessThan(String value) {
            addCriterion("credit_report_pic <", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picLessThanOrEqualTo(String value) {
            addCriterion("credit_report_pic <=", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picLike(String value) {
            addCriterion("credit_report_pic like", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picNotLike(String value) {
            addCriterion("credit_report_pic not like", value, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picIn(List<String> values) {
            addCriterion("credit_report_pic in", values, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picNotIn(List<String> values) {
            addCriterion("credit_report_pic not in", values, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picBetween(String value1, String value2) {
            addCriterion("credit_report_pic between", value1, value2, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andCredit_report_picNotBetween(String value1, String value2) {
            addCriterion("credit_report_pic not between", value1, value2, "credit_report_pic");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntIsNull() {
            addCriterion("amortization_cnt is null");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntIsNotNull() {
            addCriterion("amortization_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntEqualTo(Integer value) {
            addCriterion("amortization_cnt =", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntNotEqualTo(Integer value) {
            addCriterion("amortization_cnt <>", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntGreaterThan(Integer value) {
            addCriterion("amortization_cnt >", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntGreaterThanOrEqualTo(Integer value) {
            addCriterion("amortization_cnt >=", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntLessThan(Integer value) {
            addCriterion("amortization_cnt <", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntLessThanOrEqualTo(Integer value) {
            addCriterion("amortization_cnt <=", value, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntIn(List<Integer> values) {
            addCriterion("amortization_cnt in", values, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntNotIn(List<Integer> values) {
            addCriterion("amortization_cnt not in", values, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntBetween(Integer value1, Integer value2) {
            addCriterion("amortization_cnt between", value1, value2, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_cntNotBetween(Integer value1, Integer value2) {
            addCriterion("amortization_cnt not between", value1, value2, "amortization_cnt");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyIsNull() {
            addCriterion("amortization_money is null");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyIsNotNull() {
            addCriterion("amortization_money is not null");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyEqualTo(String value) {
            addCriterion("amortization_money =", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyNotEqualTo(String value) {
            addCriterion("amortization_money <>", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyGreaterThan(String value) {
            addCriterion("amortization_money >", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyGreaterThanOrEqualTo(String value) {
            addCriterion("amortization_money >=", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyLessThan(String value) {
            addCriterion("amortization_money <", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyLessThanOrEqualTo(String value) {
            addCriterion("amortization_money <=", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyLike(String value) {
            addCriterion("amortization_money like", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyNotLike(String value) {
            addCriterion("amortization_money not like", value, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyIn(List<String> values) {
            addCriterion("amortization_money in", values, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyNotIn(List<String> values) {
            addCriterion("amortization_money not in", values, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyBetween(String value1, String value2) {
            addCriterion("amortization_money between", value1, value2, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andAmortization_moneyNotBetween(String value1, String value2) {
            addCriterion("amortization_money not between", value1, value2, "amortization_money");
            return (Criteria) this;
        }

        public Criteria andStore_uidIsNull() {
            addCriterion("store_uid is null");
            return (Criteria) this;
        }

        public Criteria andStore_uidIsNotNull() {
            addCriterion("store_uid is not null");
            return (Criteria) this;
        }

        public Criteria andStore_uidEqualTo(Long value) {
            addCriterion("store_uid =", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidNotEqualTo(Long value) {
            addCriterion("store_uid <>", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidGreaterThan(Long value) {
            addCriterion("store_uid >", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidGreaterThanOrEqualTo(Long value) {
            addCriterion("store_uid >=", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidLessThan(Long value) {
            addCriterion("store_uid <", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidLessThanOrEqualTo(Long value) {
            addCriterion("store_uid <=", value, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidIn(List<Long> values) {
            addCriterion("store_uid in", values, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidNotIn(List<Long> values) {
            addCriterion("store_uid not in", values, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidBetween(Long value1, Long value2) {
            addCriterion("store_uid between", value1, value2, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_uidNotBetween(Long value1, Long value2) {
            addCriterion("store_uid not between", value1, value2, "store_uid");
            return (Criteria) this;
        }

        public Criteria andStore_nameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStore_nameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStore_nameEqualTo(String value) {
            addCriterion("store_name =", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameGreaterThan(String value) {
            addCriterion("store_name >", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLessThan(String value) {
            addCriterion("store_name <", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLike(String value) {
            addCriterion("store_name like", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotLike(String value) {
            addCriterion("store_name not like", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameIn(List<String> values) {
            addCriterion("store_name in", values, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "store_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidIsNull() {
            addCriterion("borrow_uid is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidIsNotNull() {
            addCriterion("borrow_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidEqualTo(Long value) {
            addCriterion("borrow_uid =", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidNotEqualTo(Long value) {
            addCriterion("borrow_uid <>", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidGreaterThan(Long value) {
            addCriterion("borrow_uid >", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidGreaterThanOrEqualTo(Long value) {
            addCriterion("borrow_uid >=", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidLessThan(Long value) {
            addCriterion("borrow_uid <", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidLessThanOrEqualTo(Long value) {
            addCriterion("borrow_uid <=", value, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidIn(List<Long> values) {
            addCriterion("borrow_uid in", values, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidNotIn(List<Long> values) {
            addCriterion("borrow_uid not in", values, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidBetween(Long value1, Long value2) {
            addCriterion("borrow_uid between", value1, value2, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andBorrow_uidNotBetween(Long value1, Long value2) {
            addCriterion("borrow_uid not between", value1, value2, "borrow_uid");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateIsNull() {
            addCriterion("store_charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateIsNotNull() {
            addCriterion("store_charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateEqualTo(BigDecimal value) {
            addCriterion("store_charge_rate =", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateNotEqualTo(BigDecimal value) {
            addCriterion("store_charge_rate <>", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateGreaterThan(BigDecimal value) {
            addCriterion("store_charge_rate >", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_charge_rate >=", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateLessThan(BigDecimal value) {
            addCriterion("store_charge_rate <", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_charge_rate <=", value, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateIn(List<BigDecimal> values) {
            addCriterion("store_charge_rate in", values, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateNotIn(List<BigDecimal> values) {
            addCriterion("store_charge_rate not in", values, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_charge_rate between", value1, value2, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andStore_charge_rateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_charge_rate not between", value1, value2, "store_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateIsNull() {
            addCriterion("user_charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateIsNotNull() {
            addCriterion("user_charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateEqualTo(BigDecimal value) {
            addCriterion("user_charge_rate =", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateNotEqualTo(BigDecimal value) {
            addCriterion("user_charge_rate <>", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateGreaterThan(BigDecimal value) {
            addCriterion("user_charge_rate >", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_charge_rate >=", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateLessThan(BigDecimal value) {
            addCriterion("user_charge_rate <", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_charge_rate <=", value, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateIn(List<BigDecimal> values) {
            addCriterion("user_charge_rate in", values, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateNotIn(List<BigDecimal> values) {
            addCriterion("user_charge_rate not in", values, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_charge_rate between", value1, value2, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andUser_charge_rateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_charge_rate not between", value1, value2, "user_charge_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateIsNull() {
            addCriterion("borrow_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateIsNotNull() {
            addCriterion("borrow_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateEqualTo(BigDecimal value) {
            addCriterion("borrow_interest_rate =", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateNotEqualTo(BigDecimal value) {
            addCriterion("borrow_interest_rate <>", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateGreaterThan(BigDecimal value) {
            addCriterion("borrow_interest_rate >", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_interest_rate >=", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateLessThan(BigDecimal value) {
            addCriterion("borrow_interest_rate <", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_interest_rate <=", value, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateIn(List<BigDecimal> values) {
            addCriterion("borrow_interest_rate in", values, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateNotIn(List<BigDecimal> values) {
            addCriterion("borrow_interest_rate not in", values, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_interest_rate between", value1, value2, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andBorrow_interest_rateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_interest_rate not between", value1, value2, "borrow_interest_rate");
            return (Criteria) this;
        }

        public Criteria andStore_contractIsNull() {
            addCriterion("store_contract is null");
            return (Criteria) this;
        }

        public Criteria andStore_contractIsNotNull() {
            addCriterion("store_contract is not null");
            return (Criteria) this;
        }

        public Criteria andStore_contractEqualTo(String value) {
            addCriterion("store_contract =", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractNotEqualTo(String value) {
            addCriterion("store_contract <>", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractGreaterThan(String value) {
            addCriterion("store_contract >", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractGreaterThanOrEqualTo(String value) {
            addCriterion("store_contract >=", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractLessThan(String value) {
            addCriterion("store_contract <", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractLessThanOrEqualTo(String value) {
            addCriterion("store_contract <=", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractLike(String value) {
            addCriterion("store_contract like", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractNotLike(String value) {
            addCriterion("store_contract not like", value, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractIn(List<String> values) {
            addCriterion("store_contract in", values, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractNotIn(List<String> values) {
            addCriterion("store_contract not in", values, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractBetween(String value1, String value2) {
            addCriterion("store_contract between", value1, value2, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_contractNotBetween(String value1, String value2) {
            addCriterion("store_contract not between", value1, value2, "store_contract");
            return (Criteria) this;
        }

        public Criteria andStore_telIsNull() {
            addCriterion("store_tel is null");
            return (Criteria) this;
        }

        public Criteria andStore_telIsNotNull() {
            addCriterion("store_tel is not null");
            return (Criteria) this;
        }

        public Criteria andStore_telEqualTo(String value) {
            addCriterion("store_tel =", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telNotEqualTo(String value) {
            addCriterion("store_tel <>", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telGreaterThan(String value) {
            addCriterion("store_tel >", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telGreaterThanOrEqualTo(String value) {
            addCriterion("store_tel >=", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telLessThan(String value) {
            addCriterion("store_tel <", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telLessThanOrEqualTo(String value) {
            addCriterion("store_tel <=", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telLike(String value) {
            addCriterion("store_tel like", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telNotLike(String value) {
            addCriterion("store_tel not like", value, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telIn(List<String> values) {
            addCriterion("store_tel in", values, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telNotIn(List<String> values) {
            addCriterion("store_tel not in", values, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telBetween(String value1, String value2) {
            addCriterion("store_tel between", value1, value2, "store_tel");
            return (Criteria) this;
        }

        public Criteria andStore_telNotBetween(String value1, String value2) {
            addCriterion("store_tel not between", value1, value2, "store_tel");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkIsNull() {
            addCriterion("check_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkIsNotNull() {
            addCriterion("check_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkEqualTo(String value) {
            addCriterion("check_remark =", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkNotEqualTo(String value) {
            addCriterion("check_remark <>", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkGreaterThan(String value) {
            addCriterion("check_remark >", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_remark >=", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkLessThan(String value) {
            addCriterion("check_remark <", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkLessThanOrEqualTo(String value) {
            addCriterion("check_remark <=", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkLike(String value) {
            addCriterion("check_remark like", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkNotLike(String value) {
            addCriterion("check_remark not like", value, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkIn(List<String> values) {
            addCriterion("check_remark in", values, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkNotIn(List<String> values) {
            addCriterion("check_remark not in", values, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkBetween(String value1, String value2) {
            addCriterion("check_remark between", value1, value2, "check_remark");
            return (Criteria) this;
        }

        public Criteria andCheck_remarkNotBetween(String value1, String value2) {
            addCriterion("check_remark not between", value1, value2, "check_remark");
            return (Criteria) this;
        }

        public Criteria andRemit_timeIsNull() {
            addCriterion("remit_time is null");
            return (Criteria) this;
        }

        public Criteria andRemit_timeIsNotNull() {
            addCriterion("remit_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemit_timeEqualTo(Date value) {
            addCriterion("remit_time =", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeNotEqualTo(Date value) {
            addCriterion("remit_time <>", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeGreaterThan(Date value) {
            addCriterion("remit_time >", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("remit_time >=", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeLessThan(Date value) {
            addCriterion("remit_time <", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeLessThanOrEqualTo(Date value) {
            addCriterion("remit_time <=", value, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeIn(List<Date> values) {
            addCriterion("remit_time in", values, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeNotIn(List<Date> values) {
            addCriterion("remit_time not in", values, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeBetween(Date value1, Date value2) {
            addCriterion("remit_time between", value1, value2, "remit_time");
            return (Criteria) this;
        }

        public Criteria andRemit_timeNotBetween(Date value1, Date value2) {
            addCriterion("remit_time not between", value1, value2, "remit_time");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneIsNull() {
            addCriterion("borrower_mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneIsNotNull() {
            addCriterion("borrower_mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneEqualTo(String value) {
            addCriterion("borrower_mobile_phone =", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneNotEqualTo(String value) {
            addCriterion("borrower_mobile_phone <>", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneGreaterThan(String value) {
            addCriterion("borrower_mobile_phone >", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_mobile_phone >=", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneLessThan(String value) {
            addCriterion("borrower_mobile_phone <", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneLessThanOrEqualTo(String value) {
            addCriterion("borrower_mobile_phone <=", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneLike(String value) {
            addCriterion("borrower_mobile_phone like", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneNotLike(String value) {
            addCriterion("borrower_mobile_phone not like", value, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneIn(List<String> values) {
            addCriterion("borrower_mobile_phone in", values, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneNotIn(List<String> values) {
            addCriterion("borrower_mobile_phone not in", values, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneBetween(String value1, String value2) {
            addCriterion("borrower_mobile_phone between", value1, value2, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andBorrower_mobile_phoneNotBetween(String value1, String value2) {
            addCriterion("borrower_mobile_phone not between", value1, value2, "borrower_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiIsNull() {
            addCriterion("mobile_imei is null");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiIsNotNull() {
            addCriterion("mobile_imei is not null");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiEqualTo(String value) {
            addCriterion("mobile_imei =", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiNotEqualTo(String value) {
            addCriterion("mobile_imei <>", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiGreaterThan(String value) {
            addCriterion("mobile_imei >", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_imei >=", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiLessThan(String value) {
            addCriterion("mobile_imei <", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiLessThanOrEqualTo(String value) {
            addCriterion("mobile_imei <=", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiLike(String value) {
            addCriterion("mobile_imei like", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiNotLike(String value) {
            addCriterion("mobile_imei not like", value, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiIn(List<String> values) {
            addCriterion("mobile_imei in", values, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiNotIn(List<String> values) {
            addCriterion("mobile_imei not in", values, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiBetween(String value1, String value2) {
            addCriterion("mobile_imei between", value1, value2, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_imeiNotBetween(String value1, String value2) {
            addCriterion("mobile_imei not between", value1, value2, "mobile_imei");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaIsNull() {
            addCriterion("mobile_idfa is null");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaIsNotNull() {
            addCriterion("mobile_idfa is not null");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaEqualTo(String value) {
            addCriterion("mobile_idfa =", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaNotEqualTo(String value) {
            addCriterion("mobile_idfa <>", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaGreaterThan(String value) {
            addCriterion("mobile_idfa >", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_idfa >=", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaLessThan(String value) {
            addCriterion("mobile_idfa <", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaLessThanOrEqualTo(String value) {
            addCriterion("mobile_idfa <=", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaLike(String value) {
            addCriterion("mobile_idfa like", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaNotLike(String value) {
            addCriterion("mobile_idfa not like", value, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaIn(List<String> values) {
            addCriterion("mobile_idfa in", values, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaNotIn(List<String> values) {
            addCriterion("mobile_idfa not in", values, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaBetween(String value1, String value2) {
            addCriterion("mobile_idfa between", value1, value2, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andMobile_idfaNotBetween(String value1, String value2) {
            addCriterion("mobile_idfa not between", value1, value2, "mobile_idfa");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andContract_numberIsNull() {
            addCriterion("contract_number is null");
            return (Criteria) this;
        }

        public Criteria andContract_numberIsNotNull() {
            addCriterion("contract_number is not null");
            return (Criteria) this;
        }

        public Criteria andContract_numberEqualTo(String value) {
            addCriterion("contract_number =", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberNotEqualTo(String value) {
            addCriterion("contract_number <>", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberGreaterThan(String value) {
            addCriterion("contract_number >", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberGreaterThanOrEqualTo(String value) {
            addCriterion("contract_number >=", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberLessThan(String value) {
            addCriterion("contract_number <", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberLessThanOrEqualTo(String value) {
            addCriterion("contract_number <=", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberLike(String value) {
            addCriterion("contract_number like", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberNotLike(String value) {
            addCriterion("contract_number not like", value, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberIn(List<String> values) {
            addCriterion("contract_number in", values, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberNotIn(List<String> values) {
            addCriterion("contract_number not in", values, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberBetween(String value1, String value2) {
            addCriterion("contract_number between", value1, value2, "contract_number");
            return (Criteria) this;
        }

        public Criteria andContract_numberNotBetween(String value1, String value2) {
            addCriterion("contract_number not between", value1, value2, "contract_number");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picIsNull() {
            addCriterion("check_alive_pic is null");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picIsNotNull() {
            addCriterion("check_alive_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picEqualTo(String value) {
            addCriterion("check_alive_pic =", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picNotEqualTo(String value) {
            addCriterion("check_alive_pic <>", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picGreaterThan(String value) {
            addCriterion("check_alive_pic >", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picGreaterThanOrEqualTo(String value) {
            addCriterion("check_alive_pic >=", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picLessThan(String value) {
            addCriterion("check_alive_pic <", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picLessThanOrEqualTo(String value) {
            addCriterion("check_alive_pic <=", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picLike(String value) {
            addCriterion("check_alive_pic like", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picNotLike(String value) {
            addCriterion("check_alive_pic not like", value, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picIn(List<String> values) {
            addCriterion("check_alive_pic in", values, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picNotIn(List<String> values) {
            addCriterion("check_alive_pic not in", values, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picBetween(String value1, String value2) {
            addCriterion("check_alive_pic between", value1, value2, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andCheck_alive_picNotBetween(String value1, String value2) {
            addCriterion("check_alive_pic not between", value1, value2, "check_alive_pic");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultIsNull() {
            addCriterion("xiaoshi_check_alive_result is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultIsNotNull() {
            addCriterion("xiaoshi_check_alive_result is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultEqualTo(Integer value) {
            addCriterion("xiaoshi_check_alive_result =", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultNotEqualTo(Integer value) {
            addCriterion("xiaoshi_check_alive_result <>", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultGreaterThan(Integer value) {
            addCriterion("xiaoshi_check_alive_result >", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiaoshi_check_alive_result >=", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultLessThan(Integer value) {
            addCriterion("xiaoshi_check_alive_result <", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultLessThanOrEqualTo(Integer value) {
            addCriterion("xiaoshi_check_alive_result <=", value, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultIn(List<Integer> values) {
            addCriterion("xiaoshi_check_alive_result in", values, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultNotIn(List<Integer> values) {
            addCriterion("xiaoshi_check_alive_result not in", values, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshi_check_alive_result between", value1, value2, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_check_alive_resultNotBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshi_check_alive_result not between", value1, value2, "xiaoshi_check_alive_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultIsNull() {
            addCriterion("xiaoshi_id_card_check_result is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultIsNotNull() {
            addCriterion("xiaoshi_id_card_check_result is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultEqualTo(Integer value) {
            addCriterion("xiaoshi_id_card_check_result =", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotEqualTo(Integer value) {
            addCriterion("xiaoshi_id_card_check_result <>", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultGreaterThan(Integer value) {
            addCriterion("xiaoshi_id_card_check_result >", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiaoshi_id_card_check_result >=", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultLessThan(Integer value) {
            addCriterion("xiaoshi_id_card_check_result <", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultLessThanOrEqualTo(Integer value) {
            addCriterion("xiaoshi_id_card_check_result <=", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultIn(List<Integer> values) {
            addCriterion("xiaoshi_id_card_check_result in", values, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotIn(List<Integer> values) {
            addCriterion("xiaoshi_id_card_check_result not in", values, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshi_id_card_check_result between", value1, value2, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotBetween(Integer value1, Integer value2) {
            addCriterion("xiaoshi_id_card_check_result not between", value1, value2, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgIsNull() {
            addCriterion("xiaoshi_id_card_check_msg is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgIsNotNull() {
            addCriterion("xiaoshi_id_card_check_msg is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_msg =", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgNotEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_msg <>", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgGreaterThan(String value) {
            addCriterion("xiaoshi_id_card_check_msg >", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_msg >=", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgLessThan(String value) {
            addCriterion("xiaoshi_id_card_check_msg <", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgLessThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_msg <=", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgLike(String value) {
            addCriterion("xiaoshi_id_card_check_msg like", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgNotLike(String value) {
            addCriterion("xiaoshi_id_card_check_msg not like", value, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_msg in", values, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgNotIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_msg not in", values, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_msg between", value1, value2, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_msgNotBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_msg not between", value1, value2, "xiaoshi_id_card_check_msg");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreIsNull() {
            addCriterion("xiaoshi_id_card_check_score is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreIsNotNull() {
            addCriterion("xiaoshi_id_card_check_score is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_score =", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreNotEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_score <>", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreGreaterThan(String value) {
            addCriterion("xiaoshi_id_card_check_score >", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_score >=", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreLessThan(String value) {
            addCriterion("xiaoshi_id_card_check_score <", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreLessThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_score <=", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreLike(String value) {
            addCriterion("xiaoshi_id_card_check_score like", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreNotLike(String value) {
            addCriterion("xiaoshi_id_card_check_score not like", value, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_score in", values, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreNotIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_score not in", values, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_score between", value1, value2, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_scoreNotBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_score not between", value1, value2, "xiaoshi_id_card_check_score");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidIsNull() {
            addCriterion("xiaoshi_id_card_check_guid is null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidIsNotNull() {
            addCriterion("xiaoshi_id_card_check_guid is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_guid =", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidNotEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_guid <>", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidGreaterThan(String value) {
            addCriterion("xiaoshi_id_card_check_guid >", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_guid >=", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidLessThan(String value) {
            addCriterion("xiaoshi_id_card_check_guid <", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidLessThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_guid <=", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidLike(String value) {
            addCriterion("xiaoshi_id_card_check_guid like", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidNotLike(String value) {
            addCriterion("xiaoshi_id_card_check_guid not like", value, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_guid in", values, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidNotIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_guid not in", values, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_guid between", value1, value2, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_guidNotBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_guid not between", value1, value2, "xiaoshi_id_card_check_guid");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceEqualTo(Integer value) {
            addCriterion("order_source =", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceNotEqualTo(Integer value) {
            addCriterion("order_source <>", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceGreaterThan(Integer value) {
            addCriterion("order_source >", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_source >=", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceLessThan(Integer value) {
            addCriterion("order_source <", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceLessThanOrEqualTo(Integer value) {
            addCriterion("order_source <=", value, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceIn(List<Integer> values) {
            addCriterion("order_source in", values, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceNotIn(List<Integer> values) {
            addCriterion("order_source not in", values, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceBetween(Integer value1, Integer value2) {
            addCriterion("order_source between", value1, value2, "order_source");
            return (Criteria) this;
        }

        public Criteria andOrder_sourceNotBetween(Integer value1, Integer value2) {
            addCriterion("order_source not between", value1, value2, "order_source");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameIsNull() {
            addCriterion("store_type_name is null");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameIsNotNull() {
            addCriterion("store_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameEqualTo(String value) {
            addCriterion("store_type_name =", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameNotEqualTo(String value) {
            addCriterion("store_type_name <>", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameGreaterThan(String value) {
            addCriterion("store_type_name >", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameGreaterThanOrEqualTo(String value) {
            addCriterion("store_type_name >=", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameLessThan(String value) {
            addCriterion("store_type_name <", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameLessThanOrEqualTo(String value) {
            addCriterion("store_type_name <=", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameLike(String value) {
            addCriterion("store_type_name like", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameNotLike(String value) {
            addCriterion("store_type_name not like", value, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameIn(List<String> values) {
            addCriterion("store_type_name in", values, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameNotIn(List<String> values) {
            addCriterion("store_type_name not in", values, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameBetween(String value1, String value2) {
            addCriterion("store_type_name between", value1, value2, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andStore_type_nameNotBetween(String value1, String value2) {
            addCriterion("store_type_name not between", value1, value2, "store_type_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_idIsNull() {
            addCriterion("rule_set_id is null");
            return (Criteria) this;
        }

        public Criteria andRule_set_idIsNotNull() {
            addCriterion("rule_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andRule_set_idEqualTo(Long value) {
            addCriterion("rule_set_id =", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotEqualTo(Long value) {
            addCriterion("rule_set_id <>", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idGreaterThan(Long value) {
            addCriterion("rule_set_id >", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_set_id >=", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idLessThan(Long value) {
            addCriterion("rule_set_id <", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idLessThanOrEqualTo(Long value) {
            addCriterion("rule_set_id <=", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idIn(List<Long> values) {
            addCriterion("rule_set_id in", values, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotIn(List<Long> values) {
            addCriterion("rule_set_id not in", values, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idBetween(Long value1, Long value2) {
            addCriterion("rule_set_id between", value1, value2, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotBetween(Long value1, Long value2) {
            addCriterion("rule_set_id not between", value1, value2, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportIsNull() {
            addCriterion("have_scoring_report is null");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportIsNotNull() {
            addCriterion("have_scoring_report is not null");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportEqualTo(Integer value) {
            addCriterion("have_scoring_report =", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportNotEqualTo(Integer value) {
            addCriterion("have_scoring_report <>", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportGreaterThan(Integer value) {
            addCriterion("have_scoring_report >", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_scoring_report >=", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportLessThan(Integer value) {
            addCriterion("have_scoring_report <", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportLessThanOrEqualTo(Integer value) {
            addCriterion("have_scoring_report <=", value, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportIn(List<Integer> values) {
            addCriterion("have_scoring_report in", values, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportNotIn(List<Integer> values) {
            addCriterion("have_scoring_report not in", values, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportBetween(Integer value1, Integer value2) {
            addCriterion("have_scoring_report between", value1, value2, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andHave_scoring_reportNotBetween(Integer value1, Integer value2) {
            addCriterion("have_scoring_report not between", value1, value2, "have_scoring_report");
            return (Criteria) this;
        }

        public Criteria andInterest_typeIsNull() {
            addCriterion("interest_type is null");
            return (Criteria) this;
        }

        public Criteria andInterest_typeIsNotNull() {
            addCriterion("interest_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterest_typeEqualTo(Byte value) {
            addCriterion("interest_type =", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeNotEqualTo(Byte value) {
            addCriterion("interest_type <>", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeGreaterThan(Byte value) {
            addCriterion("interest_type >", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("interest_type >=", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeLessThan(Byte value) {
            addCriterion("interest_type <", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeLessThanOrEqualTo(Byte value) {
            addCriterion("interest_type <=", value, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeIn(List<Byte> values) {
            addCriterion("interest_type in", values, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeNotIn(List<Byte> values) {
            addCriterion("interest_type not in", values, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeBetween(Byte value1, Byte value2) {
            addCriterion("interest_type between", value1, value2, "interest_type");
            return (Criteria) this;
        }

        public Criteria andInterest_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("interest_type not between", value1, value2, "interest_type");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestIsNull() {
            addCriterion("borrow_interest is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestIsNotNull() {
            addCriterion("borrow_interest is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestEqualTo(BigDecimal value) {
            addCriterion("borrow_interest =", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestNotEqualTo(BigDecimal value) {
            addCriterion("borrow_interest <>", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestGreaterThan(BigDecimal value) {
            addCriterion("borrow_interest >", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_interest >=", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestLessThan(BigDecimal value) {
            addCriterion("borrow_interest <", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_interest <=", value, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestIn(List<BigDecimal> values) {
            addCriterion("borrow_interest in", values, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestNotIn(List<BigDecimal> values) {
            addCriterion("borrow_interest not in", values, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_interest between", value1, value2, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andBorrow_interestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_interest not between", value1, value2, "borrow_interest");
            return (Criteria) this;
        }

        public Criteria andEach_amountIsNull() {
            addCriterion("each_amount is null");
            return (Criteria) this;
        }

        public Criteria andEach_amountIsNotNull() {
            addCriterion("each_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEach_amountEqualTo(BigDecimal value) {
            addCriterion("each_amount =", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountNotEqualTo(BigDecimal value) {
            addCriterion("each_amount <>", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountGreaterThan(BigDecimal value) {
            addCriterion("each_amount >", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("each_amount >=", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountLessThan(BigDecimal value) {
            addCriterion("each_amount <", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("each_amount <=", value, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountIn(List<BigDecimal> values) {
            addCriterion("each_amount in", values, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountNotIn(List<BigDecimal> values) {
            addCriterion("each_amount not in", values, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("each_amount between", value1, value2, "each_amount");
            return (Criteria) this;
        }

        public Criteria andEach_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("each_amount not between", value1, value2, "each_amount");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationIsNull() {
            addCriterion("borrow_duration is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationIsNotNull() {
            addCriterion("borrow_duration is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationEqualTo(Integer value) {
            addCriterion("borrow_duration =", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationNotEqualTo(Integer value) {
            addCriterion("borrow_duration <>", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationGreaterThan(Integer value) {
            addCriterion("borrow_duration >", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrow_duration >=", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationLessThan(Integer value) {
            addCriterion("borrow_duration <", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationLessThanOrEqualTo(Integer value) {
            addCriterion("borrow_duration <=", value, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationIn(List<Integer> values) {
            addCriterion("borrow_duration in", values, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationNotIn(List<Integer> values) {
            addCriterion("borrow_duration not in", values, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationBetween(Integer value1, Integer value2) {
            addCriterion("borrow_duration between", value1, value2, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andBorrow_durationNotBetween(Integer value1, Integer value2) {
            addCriterion("borrow_duration not between", value1, value2, "borrow_duration");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andBorrow_useIsNull() {
            addCriterion("borrow_use is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_useIsNotNull() {
            addCriterion("borrow_use is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_useEqualTo(Byte value) {
            addCriterion("borrow_use =", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useNotEqualTo(Byte value) {
            addCriterion("borrow_use <>", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useGreaterThan(Byte value) {
            addCriterion("borrow_use >", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useGreaterThanOrEqualTo(Byte value) {
            addCriterion("borrow_use >=", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useLessThan(Byte value) {
            addCriterion("borrow_use <", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useLessThanOrEqualTo(Byte value) {
            addCriterion("borrow_use <=", value, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useIn(List<Byte> values) {
            addCriterion("borrow_use in", values, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useNotIn(List<Byte> values) {
            addCriterion("borrow_use not in", values, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useBetween(Byte value1, Byte value2) {
            addCriterion("borrow_use between", value1, value2, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andBorrow_useNotBetween(Byte value1, Byte value2) {
            addCriterion("borrow_use not between", value1, value2, "borrow_use");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_statusEqualTo(Byte value) {
            addCriterion("check_status =", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusLessThan(Byte value) {
            addCriterion("check_status <", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusIn(List<Byte> values) {
            addCriterion("check_status in", values, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "check_status");
            return (Criteria) this;
        }

        public Criteria andCheck_statusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "check_status");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookIsNull() {
            addCriterion("borrower_address_book is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookIsNotNull() {
            addCriterion("borrower_address_book is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookEqualTo(String value) {
            addCriterion("borrower_address_book =", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookNotEqualTo(String value) {
            addCriterion("borrower_address_book <>", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookGreaterThan(String value) {
            addCriterion("borrower_address_book >", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_address_book >=", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookLessThan(String value) {
            addCriterion("borrower_address_book <", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookLessThanOrEqualTo(String value) {
            addCriterion("borrower_address_book <=", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookLike(String value) {
            addCriterion("borrower_address_book like", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookNotLike(String value) {
            addCriterion("borrower_address_book not like", value, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookIn(List<String> values) {
            addCriterion("borrower_address_book in", values, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookNotIn(List<String> values) {
            addCriterion("borrower_address_book not in", values, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookBetween(String value1, String value2) {
            addCriterion("borrower_address_book between", value1, value2, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_address_bookNotBetween(String value1, String value2) {
            addCriterion("borrower_address_book not between", value1, value2, "borrower_address_book");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsIsNull() {
            addCriterion("borrower_call_records is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsIsNotNull() {
            addCriterion("borrower_call_records is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsEqualTo(String value) {
            addCriterion("borrower_call_records =", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsNotEqualTo(String value) {
            addCriterion("borrower_call_records <>", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsGreaterThan(String value) {
            addCriterion("borrower_call_records >", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_call_records >=", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsLessThan(String value) {
            addCriterion("borrower_call_records <", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsLessThanOrEqualTo(String value) {
            addCriterion("borrower_call_records <=", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsLike(String value) {
            addCriterion("borrower_call_records like", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsNotLike(String value) {
            addCriterion("borrower_call_records not like", value, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsIn(List<String> values) {
            addCriterion("borrower_call_records in", values, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsNotIn(List<String> values) {
            addCriterion("borrower_call_records not in", values, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsBetween(String value1, String value2) {
            addCriterion("borrower_call_records between", value1, value2, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_call_recordsNotBetween(String value1, String value2) {
            addCriterion("borrower_call_records not between", value1, value2, "borrower_call_records");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsIsNull() {
            addCriterion("borrower_sms is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsIsNotNull() {
            addCriterion("borrower_sms is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsEqualTo(String value) {
            addCriterion("borrower_sms =", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsNotEqualTo(String value) {
            addCriterion("borrower_sms <>", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsGreaterThan(String value) {
            addCriterion("borrower_sms >", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_sms >=", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsLessThan(String value) {
            addCriterion("borrower_sms <", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsLessThanOrEqualTo(String value) {
            addCriterion("borrower_sms <=", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsLike(String value) {
            addCriterion("borrower_sms like", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsNotLike(String value) {
            addCriterion("borrower_sms not like", value, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsIn(List<String> values) {
            addCriterion("borrower_sms in", values, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsNotIn(List<String> values) {
            addCriterion("borrower_sms not in", values, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsBetween(String value1, String value2) {
            addCriterion("borrower_sms between", value1, value2, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_smsNotBetween(String value1, String value2) {
            addCriterion("borrower_sms not between", value1, value2, "borrower_sms");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameIsNull() {
            addCriterion("borrower_app_name is null");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameIsNotNull() {
            addCriterion("borrower_app_name is not null");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameEqualTo(String value) {
            addCriterion("borrower_app_name =", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameNotEqualTo(String value) {
            addCriterion("borrower_app_name <>", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameGreaterThan(String value) {
            addCriterion("borrower_app_name >", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameGreaterThanOrEqualTo(String value) {
            addCriterion("borrower_app_name >=", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameLessThan(String value) {
            addCriterion("borrower_app_name <", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameLessThanOrEqualTo(String value) {
            addCriterion("borrower_app_name <=", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameLike(String value) {
            addCriterion("borrower_app_name like", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameNotLike(String value) {
            addCriterion("borrower_app_name not like", value, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameIn(List<String> values) {
            addCriterion("borrower_app_name in", values, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameNotIn(List<String> values) {
            addCriterion("borrower_app_name not in", values, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameBetween(String value1, String value2) {
            addCriterion("borrower_app_name between", value1, value2, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrower_app_nameNotBetween(String value1, String value2) {
            addCriterion("borrower_app_name not between", value1, value2, "borrower_app_name");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractIsNull() {
            addCriterion("borrowed_contract is null");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractIsNotNull() {
            addCriterion("borrowed_contract is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractEqualTo(String value) {
            addCriterion("borrowed_contract =", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractNotEqualTo(String value) {
            addCriterion("borrowed_contract <>", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractGreaterThan(String value) {
            addCriterion("borrowed_contract >", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractGreaterThanOrEqualTo(String value) {
            addCriterion("borrowed_contract >=", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractLessThan(String value) {
            addCriterion("borrowed_contract <", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractLessThanOrEqualTo(String value) {
            addCriterion("borrowed_contract <=", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractLike(String value) {
            addCriterion("borrowed_contract like", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractNotLike(String value) {
            addCriterion("borrowed_contract not like", value, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractIn(List<String> values) {
            addCriterion("borrowed_contract in", values, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractNotIn(List<String> values) {
            addCriterion("borrowed_contract not in", values, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractBetween(String value1, String value2) {
            addCriterion("borrowed_contract between", value1, value2, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andBorrowed_contractNotBetween(String value1, String value2) {
            addCriterion("borrowed_contract not between", value1, value2, "borrowed_contract");
            return (Criteria) this;
        }

        public Criteria andOrder_allotIsNull() {
            addCriterion("order_allot is null");
            return (Criteria) this;
        }

        public Criteria andOrder_allotIsNotNull() {
            addCriterion("order_allot is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_allotEqualTo(Byte value) {
            addCriterion("order_allot =", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotNotEqualTo(Byte value) {
            addCriterion("order_allot <>", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotGreaterThan(Byte value) {
            addCriterion("order_allot >", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_allot >=", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotLessThan(Byte value) {
            addCriterion("order_allot <", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotLessThanOrEqualTo(Byte value) {
            addCriterion("order_allot <=", value, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotIn(List<Byte> values) {
            addCriterion("order_allot in", values, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotNotIn(List<Byte> values) {
            addCriterion("order_allot not in", values, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotBetween(Byte value1, Byte value2) {
            addCriterion("order_allot between", value1, value2, "order_allot");
            return (Criteria) this;
        }

        public Criteria andOrder_allotNotBetween(Byte value1, Byte value2) {
            addCriterion("order_allot not between", value1, value2, "order_allot");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepIsNull() {
            addCriterion("submit_step is null");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepIsNotNull() {
            addCriterion("submit_step is not null");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepEqualTo(Byte value) {
            addCriterion("submit_step =", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepNotEqualTo(Byte value) {
            addCriterion("submit_step <>", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepGreaterThan(Byte value) {
            addCriterion("submit_step >", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepGreaterThanOrEqualTo(Byte value) {
            addCriterion("submit_step >=", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepLessThan(Byte value) {
            addCriterion("submit_step <", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepLessThanOrEqualTo(Byte value) {
            addCriterion("submit_step <=", value, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepIn(List<Byte> values) {
            addCriterion("submit_step in", values, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepNotIn(List<Byte> values) {
            addCriterion("submit_step not in", values, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepBetween(Byte value1, Byte value2) {
            addCriterion("submit_step between", value1, value2, "submit_step");
            return (Criteria) this;
        }

        public Criteria andSubmit_stepNotBetween(Byte value1, Byte value2) {
            addCriterion("submit_step not between", value1, value2, "submit_step");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoIsNull() {
            addCriterion("borrow_info is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoIsNotNull() {
            addCriterion("borrow_info is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoEqualTo(String value) {
            addCriterion("borrow_info =", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoNotEqualTo(String value) {
            addCriterion("borrow_info <>", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoGreaterThan(String value) {
            addCriterion("borrow_info >", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_info >=", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoLessThan(String value) {
            addCriterion("borrow_info <", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoLessThanOrEqualTo(String value) {
            addCriterion("borrow_info <=", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoLike(String value) {
            addCriterion("borrow_info like", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoNotLike(String value) {
            addCriterion("borrow_info not like", value, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoIn(List<String> values) {
            addCriterion("borrow_info in", values, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoNotIn(List<String> values) {
            addCriterion("borrow_info not in", values, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoBetween(String value1, String value2) {
            addCriterion("borrow_info between", value1, value2, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_infoNotBetween(String value1, String value2) {
            addCriterion("borrow_info not between", value1, value2, "borrow_info");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameIsNull() {
            addCriterion("borrow_name is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameIsNotNull() {
            addCriterion("borrow_name is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameEqualTo(String value) {
            addCriterion("borrow_name =", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameNotEqualTo(String value) {
            addCriterion("borrow_name <>", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameGreaterThan(String value) {
            addCriterion("borrow_name >", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_name >=", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameLessThan(String value) {
            addCriterion("borrow_name <", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameLessThanOrEqualTo(String value) {
            addCriterion("borrow_name <=", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameLike(String value) {
            addCriterion("borrow_name like", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameNotLike(String value) {
            addCriterion("borrow_name not like", value, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameIn(List<String> values) {
            addCriterion("borrow_name in", values, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameNotIn(List<String> values) {
            addCriterion("borrow_name not in", values, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameBetween(String value1, String value2) {
            addCriterion("borrow_name between", value1, value2, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_nameNotBetween(String value1, String value2) {
            addCriterion("borrow_name not between", value1, value2, "borrow_name");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descIsNull() {
            addCriterion("borrow_use_desc is null");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descIsNotNull() {
            addCriterion("borrow_use_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descEqualTo(String value) {
            addCriterion("borrow_use_desc =", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descNotEqualTo(String value) {
            addCriterion("borrow_use_desc <>", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descGreaterThan(String value) {
            addCriterion("borrow_use_desc >", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_use_desc >=", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descLessThan(String value) {
            addCriterion("borrow_use_desc <", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descLessThanOrEqualTo(String value) {
            addCriterion("borrow_use_desc <=", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descLike(String value) {
            addCriterion("borrow_use_desc like", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descNotLike(String value) {
            addCriterion("borrow_use_desc not like", value, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descIn(List<String> values) {
            addCriterion("borrow_use_desc in", values, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descNotIn(List<String> values) {
            addCriterion("borrow_use_desc not in", values, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descBetween(String value1, String value2) {
            addCriterion("borrow_use_desc between", value1, value2, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andBorrow_use_descNotBetween(String value1, String value2) {
            addCriterion("borrow_use_desc not between", value1, value2, "borrow_use_desc");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountIsNull() {
            addCriterion("pedestrian_inquiry_account is null");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountIsNotNull() {
            addCriterion("pedestrian_inquiry_account is not null");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountEqualTo(String value) {
            addCriterion("pedestrian_inquiry_account =", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountNotEqualTo(String value) {
            addCriterion("pedestrian_inquiry_account <>", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountGreaterThan(String value) {
            addCriterion("pedestrian_inquiry_account >", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountGreaterThanOrEqualTo(String value) {
            addCriterion("pedestrian_inquiry_account >=", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountLessThan(String value) {
            addCriterion("pedestrian_inquiry_account <", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountLessThanOrEqualTo(String value) {
            addCriterion("pedestrian_inquiry_account <=", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountLike(String value) {
            addCriterion("pedestrian_inquiry_account like", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountNotLike(String value) {
            addCriterion("pedestrian_inquiry_account not like", value, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountIn(List<String> values) {
            addCriterion("pedestrian_inquiry_account in", values, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountNotIn(List<String> values) {
            addCriterion("pedestrian_inquiry_account not in", values, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountBetween(String value1, String value2) {
            addCriterion("pedestrian_inquiry_account between", value1, value2, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_accountNotBetween(String value1, String value2) {
            addCriterion("pedestrian_inquiry_account not between", value1, value2, "pedestrian_inquiry_account");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdIsNull() {
            addCriterion("pedestrian_inquiry_pwd is null");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdIsNotNull() {
            addCriterion("pedestrian_inquiry_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdEqualTo(String value) {
            addCriterion("pedestrian_inquiry_pwd =", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdNotEqualTo(String value) {
            addCriterion("pedestrian_inquiry_pwd <>", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdGreaterThan(String value) {
            addCriterion("pedestrian_inquiry_pwd >", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("pedestrian_inquiry_pwd >=", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdLessThan(String value) {
            addCriterion("pedestrian_inquiry_pwd <", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdLessThanOrEqualTo(String value) {
            addCriterion("pedestrian_inquiry_pwd <=", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdLike(String value) {
            addCriterion("pedestrian_inquiry_pwd like", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdNotLike(String value) {
            addCriterion("pedestrian_inquiry_pwd not like", value, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdIn(List<String> values) {
            addCriterion("pedestrian_inquiry_pwd in", values, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdNotIn(List<String> values) {
            addCriterion("pedestrian_inquiry_pwd not in", values, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdBetween(String value1, String value2) {
            addCriterion("pedestrian_inquiry_pwd between", value1, value2, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andPedestrian_inquiry_pwdNotBetween(String value1, String value2) {
            addCriterion("pedestrian_inquiry_pwd not between", value1, value2, "pedestrian_inquiry_pwd");
            return (Criteria) this;
        }

        public Criteria andStore_websiteIsNull() {
            addCriterion("store_website is null");
            return (Criteria) this;
        }

        public Criteria andStore_websiteIsNotNull() {
            addCriterion("store_website is not null");
            return (Criteria) this;
        }

        public Criteria andStore_websiteEqualTo(String value) {
            addCriterion("store_website =", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteNotEqualTo(String value) {
            addCriterion("store_website <>", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteGreaterThan(String value) {
            addCriterion("store_website >", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteGreaterThanOrEqualTo(String value) {
            addCriterion("store_website >=", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteLessThan(String value) {
            addCriterion("store_website <", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteLessThanOrEqualTo(String value) {
            addCriterion("store_website <=", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteLike(String value) {
            addCriterion("store_website like", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteNotLike(String value) {
            addCriterion("store_website not like", value, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteIn(List<String> values) {
            addCriterion("store_website in", values, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteNotIn(List<String> values) {
            addCriterion("store_website not in", values, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteBetween(String value1, String value2) {
            addCriterion("store_website between", value1, value2, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_websiteNotBetween(String value1, String value2) {
            addCriterion("store_website not between", value1, value2, "store_website");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountIsNull() {
            addCriterion("store_website_account is null");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountIsNotNull() {
            addCriterion("store_website_account is not null");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountEqualTo(String value) {
            addCriterion("store_website_account =", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountNotEqualTo(String value) {
            addCriterion("store_website_account <>", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountGreaterThan(String value) {
            addCriterion("store_website_account >", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountGreaterThanOrEqualTo(String value) {
            addCriterion("store_website_account >=", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountLessThan(String value) {
            addCriterion("store_website_account <", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountLessThanOrEqualTo(String value) {
            addCriterion("store_website_account <=", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountLike(String value) {
            addCriterion("store_website_account like", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountNotLike(String value) {
            addCriterion("store_website_account not like", value, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountIn(List<String> values) {
            addCriterion("store_website_account in", values, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountNotIn(List<String> values) {
            addCriterion("store_website_account not in", values, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountBetween(String value1, String value2) {
            addCriterion("store_website_account between", value1, value2, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andStore_website_accountNotBetween(String value1, String value2) {
            addCriterion("store_website_account not between", value1, value2, "store_website_account");
            return (Criteria) this;
        }

        public Criteria andVehicle_noIsNull() {
            addCriterion("vehicle_no is null");
            return (Criteria) this;
        }

        public Criteria andVehicle_noIsNotNull() {
            addCriterion("vehicle_no is not null");
            return (Criteria) this;
        }

        public Criteria andVehicle_noEqualTo(String value) {
            addCriterion("vehicle_no =", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noNotEqualTo(String value) {
            addCriterion("vehicle_no <>", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noGreaterThan(String value) {
            addCriterion("vehicle_no >", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_no >=", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noLessThan(String value) {
            addCriterion("vehicle_no <", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noLessThanOrEqualTo(String value) {
            addCriterion("vehicle_no <=", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noLike(String value) {
            addCriterion("vehicle_no like", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noNotLike(String value) {
            addCriterion("vehicle_no not like", value, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noIn(List<String> values) {
            addCriterion("vehicle_no in", values, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noNotIn(List<String> values) {
            addCriterion("vehicle_no not in", values, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noBetween(String value1, String value2) {
            addCriterion("vehicle_no between", value1, value2, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andVehicle_noNotBetween(String value1, String value2) {
            addCriterion("vehicle_no not between", value1, value2, "vehicle_no");
            return (Criteria) this;
        }

        public Criteria andScene_idIsNull() {
            addCriterion("scene_id is null");
            return (Criteria) this;
        }

        public Criteria andScene_idIsNotNull() {
            addCriterion("scene_id is not null");
            return (Criteria) this;
        }

        public Criteria andScene_idEqualTo(Integer value) {
            addCriterion("scene_id =", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idNotEqualTo(Integer value) {
            addCriterion("scene_id <>", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idGreaterThan(Integer value) {
            addCriterion("scene_id >", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("scene_id >=", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idLessThan(Integer value) {
            addCriterion("scene_id <", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idLessThanOrEqualTo(Integer value) {
            addCriterion("scene_id <=", value, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idIn(List<Integer> values) {
            addCriterion("scene_id in", values, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idNotIn(List<Integer> values) {
            addCriterion("scene_id not in", values, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idBetween(Integer value1, Integer value2) {
            addCriterion("scene_id between", value1, value2, "scene_id");
            return (Criteria) this;
        }

        public Criteria andScene_idNotBetween(Integer value1, Integer value2) {
            addCriterion("scene_id not between", value1, value2, "scene_id");
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