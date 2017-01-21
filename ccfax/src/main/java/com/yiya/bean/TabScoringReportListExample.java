package com.yiya.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabScoringReportListExample {
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

	public TabScoringReportListExample() {
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

        public Criteria andRule_set_idIsNull() {
            addCriterion("rule_set_id is null");
            return (Criteria) this;
        }

        public Criteria andRule_set_idIsNotNull() {
            addCriterion("rule_set_id is not null");
            return (Criteria) this;
        }

        public Criteria andRule_set_idEqualTo(Integer value) {
            addCriterion("rule_set_id =", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotEqualTo(Integer value) {
            addCriterion("rule_set_id <>", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idGreaterThan(Integer value) {
            addCriterion("rule_set_id >", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_set_id >=", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idLessThan(Integer value) {
            addCriterion("rule_set_id <", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idLessThanOrEqualTo(Integer value) {
            addCriterion("rule_set_id <=", value, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idIn(List<Integer> values) {
            addCriterion("rule_set_id in", values, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotIn(List<Integer> values) {
            addCriterion("rule_set_id not in", values, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idBetween(Integer value1, Integer value2) {
            addCriterion("rule_set_id between", value1, value2, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_idNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_set_id not between", value1, value2, "rule_set_id");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameIsNull() {
            addCriterion("rule_set_name is null");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameIsNotNull() {
            addCriterion("rule_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameEqualTo(String value) {
            addCriterion("rule_set_name =", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameNotEqualTo(String value) {
            addCriterion("rule_set_name <>", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameGreaterThan(String value) {
            addCriterion("rule_set_name >", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_set_name >=", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameLessThan(String value) {
            addCriterion("rule_set_name <", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameLessThanOrEqualTo(String value) {
            addCriterion("rule_set_name <=", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameLike(String value) {
            addCriterion("rule_set_name like", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameNotLike(String value) {
            addCriterion("rule_set_name not like", value, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameIn(List<String> values) {
            addCriterion("rule_set_name in", values, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameNotIn(List<String> values) {
            addCriterion("rule_set_name not in", values, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameBetween(String value1, String value2) {
            addCriterion("rule_set_name between", value1, value2, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andRule_set_nameNotBetween(String value1, String value2) {
            addCriterion("rule_set_name not between", value1, value2, "rule_set_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idIsNull() {
            addCriterion("scoring_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idIsNotNull() {
            addCriterion("scoring_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idEqualTo(Integer value) {
            addCriterion("scoring_rule_id =", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idNotEqualTo(Integer value) {
            addCriterion("scoring_rule_id <>", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idGreaterThan(Integer value) {
            addCriterion("scoring_rule_id >", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoring_rule_id >=", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idLessThan(Integer value) {
            addCriterion("scoring_rule_id <", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idLessThanOrEqualTo(Integer value) {
            addCriterion("scoring_rule_id <=", value, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idIn(List<Integer> values) {
            addCriterion("scoring_rule_id in", values, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idNotIn(List<Integer> values) {
            addCriterion("scoring_rule_id not in", values, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idBetween(Integer value1, Integer value2) {
            addCriterion("scoring_rule_id between", value1, value2, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_idNotBetween(Integer value1, Integer value2) {
            addCriterion("scoring_rule_id not between", value1, value2, "scoring_rule_id");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeIsNull() {
            addCriterion("scoring_rule_code is null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeIsNotNull() {
            addCriterion("scoring_rule_code is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeEqualTo(String value) {
            addCriterion("scoring_rule_code =", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeNotEqualTo(String value) {
            addCriterion("scoring_rule_code <>", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeGreaterThan(String value) {
            addCriterion("scoring_rule_code >", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_rule_code >=", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeLessThan(String value) {
            addCriterion("scoring_rule_code <", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeLessThanOrEqualTo(String value) {
            addCriterion("scoring_rule_code <=", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeLike(String value) {
            addCriterion("scoring_rule_code like", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeNotLike(String value) {
            addCriterion("scoring_rule_code not like", value, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeIn(List<String> values) {
            addCriterion("scoring_rule_code in", values, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeNotIn(List<String> values) {
            addCriterion("scoring_rule_code not in", values, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeBetween(String value1, String value2) {
            addCriterion("scoring_rule_code between", value1, value2, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_codeNotBetween(String value1, String value2) {
            addCriterion("scoring_rule_code not between", value1, value2, "scoring_rule_code");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameIsNull() {
            addCriterion("scoring_rule_name is null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameIsNotNull() {
            addCriterion("scoring_rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameEqualTo(String value) {
            addCriterion("scoring_rule_name =", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameNotEqualTo(String value) {
            addCriterion("scoring_rule_name <>", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameGreaterThan(String value) {
            addCriterion("scoring_rule_name >", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_rule_name >=", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameLessThan(String value) {
            addCriterion("scoring_rule_name <", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameLessThanOrEqualTo(String value) {
            addCriterion("scoring_rule_name <=", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameLike(String value) {
            addCriterion("scoring_rule_name like", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameNotLike(String value) {
            addCriterion("scoring_rule_name not like", value, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameIn(List<String> values) {
            addCriterion("scoring_rule_name in", values, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameNotIn(List<String> values) {
            addCriterion("scoring_rule_name not in", values, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameBetween(String value1, String value2) {
            addCriterion("scoring_rule_name between", value1, value2, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_nameNotBetween(String value1, String value2) {
            addCriterion("scoring_rule_name not between", value1, value2, "scoring_rule_name");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descIsNull() {
            addCriterion("scoring_rule_desc is null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descIsNotNull() {
            addCriterion("scoring_rule_desc is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descEqualTo(String value) {
            addCriterion("scoring_rule_desc =", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descNotEqualTo(String value) {
            addCriterion("scoring_rule_desc <>", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descGreaterThan(String value) {
            addCriterion("scoring_rule_desc >", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_rule_desc >=", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descLessThan(String value) {
            addCriterion("scoring_rule_desc <", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descLessThanOrEqualTo(String value) {
            addCriterion("scoring_rule_desc <=", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descLike(String value) {
            addCriterion("scoring_rule_desc like", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descNotLike(String value) {
            addCriterion("scoring_rule_desc not like", value, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descIn(List<String> values) {
            addCriterion("scoring_rule_desc in", values, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descNotIn(List<String> values) {
            addCriterion("scoring_rule_desc not in", values, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descBetween(String value1, String value2) {
            addCriterion("scoring_rule_desc between", value1, value2, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_rule_descNotBetween(String value1, String value2) {
            addCriterion("scoring_rule_desc not between", value1, value2, "scoring_rule_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idIsNull() {
            addCriterion("scoring_field_id is null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idIsNotNull() {
            addCriterion("scoring_field_id is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idEqualTo(Integer value) {
            addCriterion("scoring_field_id =", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idNotEqualTo(Integer value) {
            addCriterion("scoring_field_id <>", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idGreaterThan(Integer value) {
            addCriterion("scoring_field_id >", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoring_field_id >=", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idLessThan(Integer value) {
            addCriterion("scoring_field_id <", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idLessThanOrEqualTo(Integer value) {
            addCriterion("scoring_field_id <=", value, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idIn(List<Integer> values) {
            addCriterion("scoring_field_id in", values, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idNotIn(List<Integer> values) {
            addCriterion("scoring_field_id not in", values, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idBetween(Integer value1, Integer value2) {
            addCriterion("scoring_field_id between", value1, value2, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_idNotBetween(Integer value1, Integer value2) {
            addCriterion("scoring_field_id not between", value1, value2, "scoring_field_id");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameIsNull() {
            addCriterion("scoring_field_name is null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameIsNotNull() {
            addCriterion("scoring_field_name is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameEqualTo(String value) {
            addCriterion("scoring_field_name =", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameNotEqualTo(String value) {
            addCriterion("scoring_field_name <>", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameGreaterThan(String value) {
            addCriterion("scoring_field_name >", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_field_name >=", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameLessThan(String value) {
            addCriterion("scoring_field_name <", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameLessThanOrEqualTo(String value) {
            addCriterion("scoring_field_name <=", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameLike(String value) {
            addCriterion("scoring_field_name like", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameNotLike(String value) {
            addCriterion("scoring_field_name not like", value, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameIn(List<String> values) {
            addCriterion("scoring_field_name in", values, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameNotIn(List<String> values) {
            addCriterion("scoring_field_name not in", values, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameBetween(String value1, String value2) {
            addCriterion("scoring_field_name between", value1, value2, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_nameNotBetween(String value1, String value2) {
            addCriterion("scoring_field_name not between", value1, value2, "scoring_field_name");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chIsNull() {
            addCriterion("scoring_field_name_ch is null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chIsNotNull() {
            addCriterion("scoring_field_name_ch is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chEqualTo(String value) {
            addCriterion("scoring_field_name_ch =", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chNotEqualTo(String value) {
            addCriterion("scoring_field_name_ch <>", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chGreaterThan(String value) {
            addCriterion("scoring_field_name_ch >", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_field_name_ch >=", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chLessThan(String value) {
            addCriterion("scoring_field_name_ch <", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chLessThanOrEqualTo(String value) {
            addCriterion("scoring_field_name_ch <=", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chLike(String value) {
            addCriterion("scoring_field_name_ch like", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chNotLike(String value) {
            addCriterion("scoring_field_name_ch not like", value, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chIn(List<String> values) {
            addCriterion("scoring_field_name_ch in", values, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chNotIn(List<String> values) {
            addCriterion("scoring_field_name_ch not in", values, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chBetween(String value1, String value2) {
            addCriterion("scoring_field_name_ch between", value1, value2, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_name_chNotBetween(String value1, String value2) {
            addCriterion("scoring_field_name_ch not between", value1, value2, "scoring_field_name_ch");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descIsNull() {
            addCriterion("scoring_field_desc is null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descIsNotNull() {
            addCriterion("scoring_field_desc is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descEqualTo(String value) {
            addCriterion("scoring_field_desc =", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descNotEqualTo(String value) {
            addCriterion("scoring_field_desc <>", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descGreaterThan(String value) {
            addCriterion("scoring_field_desc >", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descGreaterThanOrEqualTo(String value) {
            addCriterion("scoring_field_desc >=", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descLessThan(String value) {
            addCriterion("scoring_field_desc <", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descLessThanOrEqualTo(String value) {
            addCriterion("scoring_field_desc <=", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descLike(String value) {
            addCriterion("scoring_field_desc like", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descNotLike(String value) {
            addCriterion("scoring_field_desc not like", value, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descIn(List<String> values) {
            addCriterion("scoring_field_desc in", values, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descNotIn(List<String> values) {
            addCriterion("scoring_field_desc not in", values, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descBetween(String value1, String value2) {
            addCriterion("scoring_field_desc between", value1, value2, "scoring_field_desc");
            return (Criteria) this;
        }

        public Criteria andScoring_field_descNotBetween(String value1, String value2) {
            addCriterion("scoring_field_desc not between", value1, value2, "scoring_field_desc");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueIsNull() {
            addCriterion("gather_field_value is null");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueIsNotNull() {
            addCriterion("gather_field_value is not null");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueEqualTo(String value) {
            addCriterion("gather_field_value =", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueNotEqualTo(String value) {
            addCriterion("gather_field_value <>", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueGreaterThan(String value) {
            addCriterion("gather_field_value >", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueGreaterThanOrEqualTo(String value) {
            addCriterion("gather_field_value >=", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueLessThan(String value) {
            addCriterion("gather_field_value <", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueLessThanOrEqualTo(String value) {
            addCriterion("gather_field_value <=", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueLike(String value) {
            addCriterion("gather_field_value like", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueNotLike(String value) {
            addCriterion("gather_field_value not like", value, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueIn(List<String> values) {
            addCriterion("gather_field_value in", values, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueNotIn(List<String> values) {
            addCriterion("gather_field_value not in", values, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueBetween(String value1, String value2) {
            addCriterion("gather_field_value between", value1, value2, "gather_field_value");
            return (Criteria) this;
        }

        public Criteria andGather_field_valueNotBetween(String value1, String value2) {
            addCriterion("gather_field_value not between", value1, value2, "gather_field_value");
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