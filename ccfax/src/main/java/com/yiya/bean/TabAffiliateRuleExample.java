package com.yiya.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabAffiliateRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int start;

   	private int limit;
   	
    public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public TabAffiliateRuleExample() {
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

        public Criteria andAffiliate_rule_idIsNull() {
            addCriterion("affiliate_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idIsNotNull() {
            addCriterion("affiliate_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idEqualTo(Long value) {
            addCriterion("affiliate_rule_id =", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idNotEqualTo(Long value) {
            addCriterion("affiliate_rule_id <>", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idGreaterThan(Long value) {
            addCriterion("affiliate_rule_id >", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idGreaterThanOrEqualTo(Long value) {
            addCriterion("affiliate_rule_id >=", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idLessThan(Long value) {
            addCriterion("affiliate_rule_id <", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idLessThanOrEqualTo(Long value) {
            addCriterion("affiliate_rule_id <=", value, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idIn(List<Long> values) {
            addCriterion("affiliate_rule_id in", values, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idNotIn(List<Long> values) {
            addCriterion("affiliate_rule_id not in", values, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idBetween(Long value1, Long value2) {
            addCriterion("affiliate_rule_id between", value1, value2, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andAffiliate_rule_idNotBetween(Long value1, Long value2) {
            addCriterion("affiliate_rule_id not between", value1, value2, "affiliate_rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_codeIsNull() {
            addCriterion("rule_code is null");
            return (Criteria) this;
        }

        public Criteria andRule_codeIsNotNull() {
            addCriterion("rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andRule_codeEqualTo(String value) {
            addCriterion("rule_code =", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeNotEqualTo(String value) {
            addCriterion("rule_code <>", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeGreaterThan(String value) {
            addCriterion("rule_code >", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_code >=", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeLessThan(String value) {
            addCriterion("rule_code <", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeLessThanOrEqualTo(String value) {
            addCriterion("rule_code <=", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeLike(String value) {
            addCriterion("rule_code like", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeNotLike(String value) {
            addCriterion("rule_code not like", value, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeIn(List<String> values) {
            addCriterion("rule_code in", values, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeNotIn(List<String> values) {
            addCriterion("rule_code not in", values, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeBetween(String value1, String value2) {
            addCriterion("rule_code between", value1, value2, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_codeNotBetween(String value1, String value2) {
            addCriterion("rule_code not between", value1, value2, "rule_code");
            return (Criteria) this;
        }

        public Criteria andRule_nameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRule_nameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRule_nameEqualTo(String value) {
            addCriterion("rule_name =", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameGreaterThan(String value) {
            addCriterion("rule_name >", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLessThan(String value) {
            addCriterion("rule_name <", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLike(String value) {
            addCriterion("rule_name like", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotLike(String value) {
            addCriterion("rule_name not like", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameIn(List<String> values) {
            addCriterion("rule_name in", values, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_descIsNull() {
            addCriterion("rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andRule_descIsNotNull() {
            addCriterion("rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRule_descEqualTo(String value) {
            addCriterion("rule_desc =", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descNotEqualTo(String value) {
            addCriterion("rule_desc <>", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descGreaterThan(String value) {
            addCriterion("rule_desc >", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descGreaterThanOrEqualTo(String value) {
            addCriterion("rule_desc >=", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descLessThan(String value) {
            addCriterion("rule_desc <", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descLessThanOrEqualTo(String value) {
            addCriterion("rule_desc <=", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descLike(String value) {
            addCriterion("rule_desc like", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descNotLike(String value) {
            addCriterion("rule_desc not like", value, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descIn(List<String> values) {
            addCriterion("rule_desc in", values, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descNotIn(List<String> values) {
            addCriterion("rule_desc not in", values, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descBetween(String value1, String value2) {
            addCriterion("rule_desc between", value1, value2, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andRule_descNotBetween(String value1, String value2) {
            addCriterion("rule_desc not between", value1, value2, "rule_desc");
            return (Criteria) this;
        }

        public Criteria andAdd_timeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAdd_timeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_timeEqualTo(Date value) {
            addCriterion("add_time =", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeGreaterThan(Date value) {
            addCriterion("add_time >", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeLessThan(Date value) {
            addCriterion("add_time <", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeIn(List<Date> values) {
            addCriterion("add_time in", values, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_timeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "add_time");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idIsNull() {
            addCriterion("add_usr_id is null");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idIsNotNull() {
            addCriterion("add_usr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idEqualTo(Long value) {
            addCriterion("add_usr_id =", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotEqualTo(Long value) {
            addCriterion("add_usr_id <>", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idGreaterThan(Long value) {
            addCriterion("add_usr_id >", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idGreaterThanOrEqualTo(Long value) {
            addCriterion("add_usr_id >=", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idLessThan(Long value) {
            addCriterion("add_usr_id <", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idLessThanOrEqualTo(Long value) {
            addCriterion("add_usr_id <=", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idIn(List<Long> values) {
            addCriterion("add_usr_id in", values, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotIn(List<Long> values) {
            addCriterion("add_usr_id not in", values, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idBetween(Long value1, Long value2) {
            addCriterion("add_usr_id between", value1, value2, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotBetween(Long value1, Long value2) {
            addCriterion("add_usr_id not between", value1, value2, "add_usr_id");
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