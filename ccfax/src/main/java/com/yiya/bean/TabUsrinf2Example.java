package com.yiya.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabUsrinf2Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabUsrinf2Example() {
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

        public Criteria andUsrinf_idIsNull() {
            addCriterion("usrinf_id is null");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idIsNotNull() {
            addCriterion("usrinf_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idEqualTo(Long value) {
            addCriterion("usrinf_id =", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idNotEqualTo(Long value) {
            addCriterion("usrinf_id <>", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idGreaterThan(Long value) {
            addCriterion("usrinf_id >", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idGreaterThanOrEqualTo(Long value) {
            addCriterion("usrinf_id >=", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idLessThan(Long value) {
            addCriterion("usrinf_id <", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idLessThanOrEqualTo(Long value) {
            addCriterion("usrinf_id <=", value, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idIn(List<Long> values) {
            addCriterion("usrinf_id in", values, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idNotIn(List<Long> values) {
            addCriterion("usrinf_id not in", values, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idBetween(Long value1, Long value2) {
            addCriterion("usrinf_id between", value1, value2, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsrinf_idNotBetween(Long value1, Long value2) {
            addCriterion("usrinf_id not between", value1, value2, "usrinf_id");
            return (Criteria) this;
        }

        public Criteria andUsridIsNull() {
            addCriterion("usrid is null");
            return (Criteria) this;
        }

        public Criteria andUsridIsNotNull() {
            addCriterion("usrid is not null");
            return (Criteria) this;
        }

        public Criteria andUsridEqualTo(Long value) {
            addCriterion("usrid =", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotEqualTo(Long value) {
            addCriterion("usrid <>", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThan(Long value) {
            addCriterion("usrid >", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThanOrEqualTo(Long value) {
            addCriterion("usrid >=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThan(Long value) {
            addCriterion("usrid <", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThanOrEqualTo(Long value) {
            addCriterion("usrid <=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridIn(List<Long> values) {
            addCriterion("usrid in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotIn(List<Long> values) {
            addCriterion("usrid not in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridBetween(Long value1, Long value2) {
            addCriterion("usrid between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotBetween(Long value1, Long value2) {
            addCriterion("usrid not between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNull() {
            addCriterion("usrname is null");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNotNull() {
            addCriterion("usrname is not null");
            return (Criteria) this;
        }

        public Criteria andUsrnameEqualTo(String value) {
            addCriterion("usrname =", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotEqualTo(String value) {
            addCriterion("usrname <>", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThan(String value) {
            addCriterion("usrname >", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThanOrEqualTo(String value) {
            addCriterion("usrname >=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThan(String value) {
            addCriterion("usrname <", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThanOrEqualTo(String value) {
            addCriterion("usrname <=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLike(String value) {
            addCriterion("usrname like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotLike(String value) {
            addCriterion("usrname not like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameIn(List<String> values) {
            addCriterion("usrname in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotIn(List<String> values) {
            addCriterion("usrname not in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameBetween(String value1, String value2) {
            addCriterion("usrname between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotBetween(String value1, String value2) {
            addCriterion("usrname not between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andId_cardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andId_cardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andId_cardEqualTo(String value) {
            addCriterion("id_card =", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardGreaterThan(String value) {
            addCriterion("id_card >", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLessThan(String value) {
            addCriterion("id_card <", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLike(String value) {
            addCriterion("id_card like", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotLike(String value) {
            addCriterion("id_card not like", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardIn(List<String> values) {
            addCriterion("id_card in", values, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "id_card");
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

        public Criteria andIs_face_id_passIsNull() {
            addCriterion("is_face_id_pass is null");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passIsNotNull() {
            addCriterion("is_face_id_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passEqualTo(Byte value) {
            addCriterion("is_face_id_pass =", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passNotEqualTo(Byte value) {
            addCriterion("is_face_id_pass <>", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passGreaterThan(Byte value) {
            addCriterion("is_face_id_pass >", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_face_id_pass >=", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passLessThan(Byte value) {
            addCriterion("is_face_id_pass <", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passLessThanOrEqualTo(Byte value) {
            addCriterion("is_face_id_pass <=", value, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passIn(List<Byte> values) {
            addCriterion("is_face_id_pass in", values, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passNotIn(List<Byte> values) {
            addCriterion("is_face_id_pass not in", values, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passBetween(Byte value1, Byte value2) {
            addCriterion("is_face_id_pass between", value1, value2, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andIs_face_id_passNotBetween(Byte value1, Byte value2) {
            addCriterion("is_face_id_pass not between", value1, value2, "is_face_id_pass");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagIsNull() {
            addCriterion("applyfo_flag is null");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagIsNotNull() {
            addCriterion("applyfo_flag is not null");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagEqualTo(Byte value) {
            addCriterion("applyfo_flag =", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagNotEqualTo(Byte value) {
            addCriterion("applyfo_flag <>", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagGreaterThan(Byte value) {
            addCriterion("applyfo_flag >", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagGreaterThanOrEqualTo(Byte value) {
            addCriterion("applyfo_flag >=", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagLessThan(Byte value) {
            addCriterion("applyfo_flag <", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagLessThanOrEqualTo(Byte value) {
            addCriterion("applyfo_flag <=", value, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagIn(List<Byte> values) {
            addCriterion("applyfo_flag in", values, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagNotIn(List<Byte> values) {
            addCriterion("applyfo_flag not in", values, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagBetween(Byte value1, Byte value2) {
            addCriterion("applyfo_flag between", value1, value2, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andApplyfo_flagNotBetween(Byte value1, Byte value2) {
            addCriterion("applyfo_flag not between", value1, value2, "applyfo_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagIsNull() {
            addCriterion("check_flag is null");
            return (Criteria) this;
        }

        public Criteria andCheck_flagIsNotNull() {
            addCriterion("check_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_flagEqualTo(Byte value) {
            addCriterion("check_flag =", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagNotEqualTo(Byte value) {
            addCriterion("check_flag <>", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagGreaterThan(Byte value) {
            addCriterion("check_flag >", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_flag >=", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagLessThan(Byte value) {
            addCriterion("check_flag <", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagLessThanOrEqualTo(Byte value) {
            addCriterion("check_flag <=", value, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagIn(List<Byte> values) {
            addCriterion("check_flag in", values, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagNotIn(List<Byte> values) {
            addCriterion("check_flag not in", values, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagBetween(Byte value1, Byte value2) {
            addCriterion("check_flag between", value1, value2, "check_flag");
            return (Criteria) this;
        }

        public Criteria andCheck_flagNotBetween(Byte value1, Byte value2) {
            addCriterion("check_flag not between", value1, value2, "check_flag");
            return (Criteria) this;
        }

        public Criteria andIs_loanIsNull() {
            addCriterion("is_loan is null");
            return (Criteria) this;
        }

        public Criteria andIs_loanIsNotNull() {
            addCriterion("is_loan is not null");
            return (Criteria) this;
        }

        public Criteria andIs_loanEqualTo(Byte value) {
            addCriterion("is_loan =", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanNotEqualTo(Byte value) {
            addCriterion("is_loan <>", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanGreaterThan(Byte value) {
            addCriterion("is_loan >", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_loan >=", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanLessThan(Byte value) {
            addCriterion("is_loan <", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanLessThanOrEqualTo(Byte value) {
            addCriterion("is_loan <=", value, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanIn(List<Byte> values) {
            addCriterion("is_loan in", values, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanNotIn(List<Byte> values) {
            addCriterion("is_loan not in", values, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanBetween(Byte value1, Byte value2) {
            addCriterion("is_loan between", value1, value2, "is_loan");
            return (Criteria) this;
        }

        public Criteria andIs_loanNotBetween(Byte value1, Byte value2) {
            addCriterion("is_loan not between", value1, value2, "is_loan");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitIsNull() {
            addCriterion("second_check_loan_limit is null");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitIsNotNull() {
            addCriterion("second_check_loan_limit is not null");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitEqualTo(BigDecimal value) {
            addCriterion("second_check_loan_limit =", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitNotEqualTo(BigDecimal value) {
            addCriterion("second_check_loan_limit <>", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitGreaterThan(BigDecimal value) {
            addCriterion("second_check_loan_limit >", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_check_loan_limit >=", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitLessThan(BigDecimal value) {
            addCriterion("second_check_loan_limit <", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_check_loan_limit <=", value, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitIn(List<BigDecimal> values) {
            addCriterion("second_check_loan_limit in", values, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitNotIn(List<BigDecimal> values) {
            addCriterion("second_check_loan_limit not in", values, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_check_loan_limit between", value1, value2, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andSecond_check_loan_limitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_check_loan_limit not between", value1, value2, "second_check_loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitIsNull() {
            addCriterion("loan_limit is null");
            return (Criteria) this;
        }

        public Criteria andLoan_limitIsNotNull() {
            addCriterion("loan_limit is not null");
            return (Criteria) this;
        }

        public Criteria andLoan_limitEqualTo(BigDecimal value) {
            addCriterion("loan_limit =", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitNotEqualTo(BigDecimal value) {
            addCriterion("loan_limit <>", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitGreaterThan(BigDecimal value) {
            addCriterion("loan_limit >", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_limit >=", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitLessThan(BigDecimal value) {
            addCriterion("loan_limit <", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_limit <=", value, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitIn(List<BigDecimal> values) {
            addCriterion("loan_limit in", values, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitNotIn(List<BigDecimal> values) {
            addCriterion("loan_limit not in", values, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_limit between", value1, value2, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_limitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_limit not between", value1, value2, "loan_limit");
            return (Criteria) this;
        }

        public Criteria andLoan_usedIsNull() {
            addCriterion("loan_used is null");
            return (Criteria) this;
        }

        public Criteria andLoan_usedIsNotNull() {
            addCriterion("loan_used is not null");
            return (Criteria) this;
        }

        public Criteria andLoan_usedEqualTo(BigDecimal value) {
            addCriterion("loan_used =", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedNotEqualTo(BigDecimal value) {
            addCriterion("loan_used <>", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedGreaterThan(BigDecimal value) {
            addCriterion("loan_used >", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_used >=", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedLessThan(BigDecimal value) {
            addCriterion("loan_used <", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_used <=", value, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedIn(List<BigDecimal> values) {
            addCriterion("loan_used in", values, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedNotIn(List<BigDecimal> values) {
            addCriterion("loan_used not in", values, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_used between", value1, value2, "loan_used");
            return (Criteria) this;
        }

        public Criteria andLoan_usedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_used not between", value1, value2, "loan_used");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryIsNull() {
            addCriterion("is_firstquery is null");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryIsNotNull() {
            addCriterion("is_firstquery is not null");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryEqualTo(Byte value) {
            addCriterion("is_firstquery =", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryNotEqualTo(Byte value) {
            addCriterion("is_firstquery <>", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryGreaterThan(Byte value) {
            addCriterion("is_firstquery >", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_firstquery >=", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryLessThan(Byte value) {
            addCriterion("is_firstquery <", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryLessThanOrEqualTo(Byte value) {
            addCriterion("is_firstquery <=", value, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryIn(List<Byte> values) {
            addCriterion("is_firstquery in", values, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryNotIn(List<Byte> values) {
            addCriterion("is_firstquery not in", values, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryBetween(Byte value1, Byte value2) {
            addCriterion("is_firstquery between", value1, value2, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andIs_firstqueryNotBetween(Byte value1, Byte value2) {
            addCriterion("is_firstquery not between", value1, value2, "is_firstquery");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitIsNull() {
            addCriterion("applyfor_limit is null");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitIsNotNull() {
            addCriterion("applyfor_limit is not null");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitEqualTo(BigDecimal value) {
            addCriterion("applyfor_limit =", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitNotEqualTo(BigDecimal value) {
            addCriterion("applyfor_limit <>", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitGreaterThan(BigDecimal value) {
            addCriterion("applyfor_limit >", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("applyfor_limit >=", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitLessThan(BigDecimal value) {
            addCriterion("applyfor_limit <", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("applyfor_limit <=", value, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitIn(List<BigDecimal> values) {
            addCriterion("applyfor_limit in", values, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitNotIn(List<BigDecimal> values) {
            addCriterion("applyfor_limit not in", values, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("applyfor_limit between", value1, value2, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_limitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("applyfor_limit not between", value1, value2, "applyfor_limit");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeIsNull() {
            addCriterion("applyfor_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeIsNotNull() {
            addCriterion("applyfor_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeEqualTo(Date value) {
            addCriterion("applyfor_time =", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeNotEqualTo(Date value) {
            addCriterion("applyfor_time <>", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeGreaterThan(Date value) {
            addCriterion("applyfor_time >", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("applyfor_time >=", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeLessThan(Date value) {
            addCriterion("applyfor_time <", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeLessThanOrEqualTo(Date value) {
            addCriterion("applyfor_time <=", value, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeIn(List<Date> values) {
            addCriterion("applyfor_time in", values, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeNotIn(List<Date> values) {
            addCriterion("applyfor_time not in", values, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeBetween(Date value1, Date value2) {
            addCriterion("applyfor_time between", value1, value2, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andApplyfor_timeNotBetween(Date value1, Date value2) {
            addCriterion("applyfor_time not between", value1, value2, "applyfor_time");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkIsNull() {
            addCriterion("freeze_remark is null");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkIsNotNull() {
            addCriterion("freeze_remark is not null");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkEqualTo(String value) {
            addCriterion("freeze_remark =", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkNotEqualTo(String value) {
            addCriterion("freeze_remark <>", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkGreaterThan(String value) {
            addCriterion("freeze_remark >", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_remark >=", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkLessThan(String value) {
            addCriterion("freeze_remark <", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkLessThanOrEqualTo(String value) {
            addCriterion("freeze_remark <=", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkLike(String value) {
            addCriterion("freeze_remark like", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkNotLike(String value) {
            addCriterion("freeze_remark not like", value, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkIn(List<String> values) {
            addCriterion("freeze_remark in", values, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkNotIn(List<String> values) {
            addCriterion("freeze_remark not in", values, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkBetween(String value1, String value2) {
            addCriterion("freeze_remark between", value1, value2, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andFreeze_remarkNotBetween(String value1, String value2) {
            addCriterion("freeze_remark not between", value1, value2, "freeze_remark");
            return (Criteria) this;
        }

        public Criteria andIs_activateIsNull() {
            addCriterion("is_activate is null");
            return (Criteria) this;
        }

        public Criteria andIs_activateIsNotNull() {
            addCriterion("is_activate is not null");
            return (Criteria) this;
        }

        public Criteria andIs_activateEqualTo(Byte value) {
            addCriterion("is_activate =", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateNotEqualTo(Byte value) {
            addCriterion("is_activate <>", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateGreaterThan(Byte value) {
            addCriterion("is_activate >", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_activate >=", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateLessThan(Byte value) {
            addCriterion("is_activate <", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateLessThanOrEqualTo(Byte value) {
            addCriterion("is_activate <=", value, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateIn(List<Byte> values) {
            addCriterion("is_activate in", values, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateNotIn(List<Byte> values) {
            addCriterion("is_activate not in", values, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateBetween(Byte value1, Byte value2) {
            addCriterion("is_activate between", value1, value2, "is_activate");
            return (Criteria) this;
        }

        public Criteria andIs_activateNotBetween(Byte value1, Byte value2) {
            addCriterion("is_activate not between", value1, value2, "is_activate");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeIsNull() {
            addCriterion("limit_validity_time is null");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeIsNotNull() {
            addCriterion("limit_validity_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeEqualTo(Date value) {
            addCriterion("limit_validity_time =", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeNotEqualTo(Date value) {
            addCriterion("limit_validity_time <>", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeGreaterThan(Date value) {
            addCriterion("limit_validity_time >", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("limit_validity_time >=", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeLessThan(Date value) {
            addCriterion("limit_validity_time <", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeLessThanOrEqualTo(Date value) {
            addCriterion("limit_validity_time <=", value, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeIn(List<Date> values) {
            addCriterion("limit_validity_time in", values, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeNotIn(List<Date> values) {
            addCriterion("limit_validity_time not in", values, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeBetween(Date value1, Date value2) {
            addCriterion("limit_validity_time between", value1, value2, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andLimit_validity_timeNotBetween(Date value1, Date value2) {
            addCriterion("limit_validity_time not between", value1, value2, "limit_validity_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeIsNull() {
            addCriterion("credit_time is null");
            return (Criteria) this;
        }

        public Criteria andCredit_timeIsNotNull() {
            addCriterion("credit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCredit_timeEqualTo(Date value) {
            addCriterion("credit_time =", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeNotEqualTo(Date value) {
            addCriterion("credit_time <>", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeGreaterThan(Date value) {
            addCriterion("credit_time >", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("credit_time >=", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeLessThan(Date value) {
            addCriterion("credit_time <", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeLessThanOrEqualTo(Date value) {
            addCriterion("credit_time <=", value, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeIn(List<Date> values) {
            addCriterion("credit_time in", values, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeNotIn(List<Date> values) {
            addCriterion("credit_time not in", values, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeBetween(Date value1, Date value2) {
            addCriterion("credit_time between", value1, value2, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_timeNotBetween(Date value1, Date value2) {
            addCriterion("credit_time not between", value1, value2, "credit_time");
            return (Criteria) this;
        }

        public Criteria andCredit_typeIsNull() {
            addCriterion("credit_type is null");
            return (Criteria) this;
        }

        public Criteria andCredit_typeIsNotNull() {
            addCriterion("credit_type is not null");
            return (Criteria) this;
        }

        public Criteria andCredit_typeEqualTo(Byte value) {
            addCriterion("credit_type =", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeNotEqualTo(Byte value) {
            addCriterion("credit_type <>", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeGreaterThan(Byte value) {
            addCriterion("credit_type >", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeGreaterThanOrEqualTo(Byte value) {
            addCriterion("credit_type >=", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeLessThan(Byte value) {
            addCriterion("credit_type <", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeLessThanOrEqualTo(Byte value) {
            addCriterion("credit_type <=", value, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeIn(List<Byte> values) {
            addCriterion("credit_type in", values, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeNotIn(List<Byte> values) {
            addCriterion("credit_type not in", values, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeBetween(Byte value1, Byte value2) {
            addCriterion("credit_type between", value1, value2, "credit_type");
            return (Criteria) this;
        }

        public Criteria andCredit_typeNotBetween(Byte value1, Byte value2) {
            addCriterion("credit_type not between", value1, value2, "credit_type");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorIsNull() {
            addCriterion("first_check_operator is null");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorIsNotNull() {
            addCriterion("first_check_operator is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorEqualTo(String value) {
            addCriterion("first_check_operator =", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorNotEqualTo(String value) {
            addCriterion("first_check_operator <>", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorGreaterThan(String value) {
            addCriterion("first_check_operator >", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorGreaterThanOrEqualTo(String value) {
            addCriterion("first_check_operator >=", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorLessThan(String value) {
            addCriterion("first_check_operator <", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorLessThanOrEqualTo(String value) {
            addCriterion("first_check_operator <=", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorLike(String value) {
            addCriterion("first_check_operator like", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorNotLike(String value) {
            addCriterion("first_check_operator not like", value, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorIn(List<String> values) {
            addCriterion("first_check_operator in", values, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorNotIn(List<String> values) {
            addCriterion("first_check_operator not in", values, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorBetween(String value1, String value2) {
            addCriterion("first_check_operator between", value1, value2, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andFirst_check_operatorNotBetween(String value1, String value2) {
            addCriterion("first_check_operator not between", value1, value2, "first_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorIsNull() {
            addCriterion("second_check_operator is null");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorIsNotNull() {
            addCriterion("second_check_operator is not null");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorEqualTo(String value) {
            addCriterion("second_check_operator =", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorNotEqualTo(String value) {
            addCriterion("second_check_operator <>", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorGreaterThan(String value) {
            addCriterion("second_check_operator >", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorGreaterThanOrEqualTo(String value) {
            addCriterion("second_check_operator >=", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorLessThan(String value) {
            addCriterion("second_check_operator <", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorLessThanOrEqualTo(String value) {
            addCriterion("second_check_operator <=", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorLike(String value) {
            addCriterion("second_check_operator like", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorNotLike(String value) {
            addCriterion("second_check_operator not like", value, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorIn(List<String> values) {
            addCriterion("second_check_operator in", values, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorNotIn(List<String> values) {
            addCriterion("second_check_operator not in", values, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorBetween(String value1, String value2) {
            addCriterion("second_check_operator between", value1, value2, "second_check_operator");
            return (Criteria) this;
        }

        public Criteria andSecond_check_operatorNotBetween(String value1, String value2) {
            addCriterion("second_check_operator not between", value1, value2, "second_check_operator");
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

        public Criteria andXiaoshi_id_card_check_resultEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_result =", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_result <>", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultGreaterThan(String value) {
            addCriterion("xiaoshi_id_card_check_result >", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_result >=", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultLessThan(String value) {
            addCriterion("xiaoshi_id_card_check_result <", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultLessThanOrEqualTo(String value) {
            addCriterion("xiaoshi_id_card_check_result <=", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultLike(String value) {
            addCriterion("xiaoshi_id_card_check_result like", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotLike(String value) {
            addCriterion("xiaoshi_id_card_check_result not like", value, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_result in", values, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotIn(List<String> values) {
            addCriterion("xiaoshi_id_card_check_result not in", values, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_result between", value1, value2, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiaoshi_id_card_check_resultNotBetween(String value1, String value2) {
            addCriterion("xiaoshi_id_card_check_result not between", value1, value2, "xiaoshi_id_card_check_result");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesIsNull() {
            addCriterion("xiao_shi_left_times is null");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesIsNotNull() {
            addCriterion("xiao_shi_left_times is not null");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesEqualTo(Integer value) {
            addCriterion("xiao_shi_left_times =", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesNotEqualTo(Integer value) {
            addCriterion("xiao_shi_left_times <>", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesGreaterThan(Integer value) {
            addCriterion("xiao_shi_left_times >", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiao_shi_left_times >=", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesLessThan(Integer value) {
            addCriterion("xiao_shi_left_times <", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesLessThanOrEqualTo(Integer value) {
            addCriterion("xiao_shi_left_times <=", value, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesIn(List<Integer> values) {
            addCriterion("xiao_shi_left_times in", values, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesNotIn(List<Integer> values) {
            addCriterion("xiao_shi_left_times not in", values, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesBetween(Integer value1, Integer value2) {
            addCriterion("xiao_shi_left_times between", value1, value2, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_left_timesNotBetween(Integer value1, Integer value2) {
            addCriterion("xiao_shi_left_times not between", value1, value2, "xiao_shi_left_times");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeIsNull() {
            addCriterion("xiao_shi_invocation_time is null");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeIsNotNull() {
            addCriterion("xiao_shi_invocation_time is not null");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeEqualTo(Date value) {
            addCriterion("xiao_shi_invocation_time =", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeNotEqualTo(Date value) {
            addCriterion("xiao_shi_invocation_time <>", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeGreaterThan(Date value) {
            addCriterion("xiao_shi_invocation_time >", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("xiao_shi_invocation_time >=", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeLessThan(Date value) {
            addCriterion("xiao_shi_invocation_time <", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeLessThanOrEqualTo(Date value) {
            addCriterion("xiao_shi_invocation_time <=", value, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeIn(List<Date> values) {
            addCriterion("xiao_shi_invocation_time in", values, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeNotIn(List<Date> values) {
            addCriterion("xiao_shi_invocation_time not in", values, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeBetween(Date value1, Date value2) {
            addCriterion("xiao_shi_invocation_time between", value1, value2, "xiao_shi_invocation_time");
            return (Criteria) this;
        }

        public Criteria andXiao_shi_invocation_timeNotBetween(Date value1, Date value2) {
            addCriterion("xiao_shi_invocation_time not between", value1, value2, "xiao_shi_invocation_time");
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