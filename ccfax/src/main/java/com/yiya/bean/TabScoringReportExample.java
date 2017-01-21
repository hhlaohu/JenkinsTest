package com.yiya.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabScoringReportExample {
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

	public TabScoringReportExample() {
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

        public Criteria andUsridIsNull() {
            addCriterion("usrid is null");
            return (Criteria) this;
        }

        public Criteria andUsridIsNotNull() {
            addCriterion("usrid is not null");
            return (Criteria) this;
        }

        public Criteria andUsridEqualTo(Integer value) {
            addCriterion("usrid =", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotEqualTo(Integer value) {
            addCriterion("usrid <>", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThan(Integer value) {
            addCriterion("usrid >", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridGreaterThanOrEqualTo(Integer value) {
            addCriterion("usrid >=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThan(Integer value) {
            addCriterion("usrid <", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridLessThanOrEqualTo(Integer value) {
            addCriterion("usrid <=", value, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridIn(List<Integer> values) {
            addCriterion("usrid in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotIn(List<Integer> values) {
            addCriterion("usrid not in", values, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridBetween(Integer value1, Integer value2) {
            addCriterion("usrid between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andUsridNotBetween(Integer value1, Integer value2) {
            addCriterion("usrid not between", value1, value2, "usrid");
            return (Criteria) this;
        }

        public Criteria andSum_scoreIsNull() {
            addCriterion("sum_score is null");
            return (Criteria) this;
        }

        public Criteria andSum_scoreIsNotNull() {
            addCriterion("sum_score is not null");
            return (Criteria) this;
        }

        public Criteria andSum_scoreEqualTo(BigDecimal value) {
            addCriterion("sum_score =", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreNotEqualTo(BigDecimal value) {
            addCriterion("sum_score <>", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreGreaterThan(BigDecimal value) {
            addCriterion("sum_score >", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_score >=", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreLessThan(BigDecimal value) {
            addCriterion("sum_score <", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sum_score <=", value, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreIn(List<BigDecimal> values) {
            addCriterion("sum_score in", values, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreNotIn(List<BigDecimal> values) {
            addCriterion("sum_score not in", values, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_score between", value1, value2, "sum_score");
            return (Criteria) this;
        }

        public Criteria andSum_scoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sum_score not between", value1, value2, "sum_score");
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

        public Criteria andAdd_usr_idIsNull() {
            addCriterion("add_usr_id is null");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idIsNotNull() {
            addCriterion("add_usr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idEqualTo(Integer value) {
            addCriterion("add_usr_id =", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotEqualTo(Integer value) {
            addCriterion("add_usr_id <>", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idGreaterThan(Integer value) {
            addCriterion("add_usr_id >", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_usr_id >=", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idLessThan(Integer value) {
            addCriterion("add_usr_id <", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idLessThanOrEqualTo(Integer value) {
            addCriterion("add_usr_id <=", value, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idIn(List<Integer> values) {
            addCriterion("add_usr_id in", values, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotIn(List<Integer> values) {
            addCriterion("add_usr_id not in", values, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idBetween(Integer value1, Integer value2) {
            addCriterion("add_usr_id between", value1, value2, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andAdd_usr_idNotBetween(Integer value1, Integer value2) {
            addCriterion("add_usr_id not between", value1, value2, "add_usr_id");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaIsNull() {
            addCriterion("scoring_quota is null");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaIsNotNull() {
            addCriterion("scoring_quota is not null");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaEqualTo(BigDecimal value) {
            addCriterion("scoring_quota =", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaNotEqualTo(BigDecimal value) {
            addCriterion("scoring_quota <>", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaGreaterThan(BigDecimal value) {
            addCriterion("scoring_quota >", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scoring_quota >=", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaLessThan(BigDecimal value) {
            addCriterion("scoring_quota <", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scoring_quota <=", value, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaIn(List<BigDecimal> values) {
            addCriterion("scoring_quota in", values, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaNotIn(List<BigDecimal> values) {
            addCriterion("scoring_quota not in", values, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scoring_quota between", value1, value2, "scoring_quota");
            return (Criteria) this;
        }

        public Criteria andScoring_quotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scoring_quota not between", value1, value2, "scoring_quota");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
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

        public Criteria andMaritalEqualTo(String value) {
            addCriterion("marital =", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotEqualTo(String value) {
            addCriterion("marital <>", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThan(String value) {
            addCriterion("marital >", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalGreaterThanOrEqualTo(String value) {
            addCriterion("marital >=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThan(String value) {
            addCriterion("marital <", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLessThanOrEqualTo(String value) {
            addCriterion("marital <=", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalLike(String value) {
            addCriterion("marital like", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotLike(String value) {
            addCriterion("marital not like", value, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalIn(List<String> values) {
            addCriterion("marital in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotIn(List<String> values) {
            addCriterion("marital not in", values, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalBetween(String value1, String value2) {
            addCriterion("marital between", value1, value2, "marital");
            return (Criteria) this;
        }

        public Criteria andMaritalNotBetween(String value1, String value2) {
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

        public Criteria andDiplomaEqualTo(String value) {
            addCriterion("diploma =", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotEqualTo(String value) {
            addCriterion("diploma <>", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThan(String value) {
            addCriterion("diploma >", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaGreaterThanOrEqualTo(String value) {
            addCriterion("diploma >=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThan(String value) {
            addCriterion("diploma <", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLessThanOrEqualTo(String value) {
            addCriterion("diploma <=", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaLike(String value) {
            addCriterion("diploma like", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotLike(String value) {
            addCriterion("diploma not like", value, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaIn(List<String> values) {
            addCriterion("diploma in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotIn(List<String> values) {
            addCriterion("diploma not in", values, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaBetween(String value1, String value2) {
            addCriterion("diploma between", value1, value2, "diploma");
            return (Criteria) this;
        }

        public Criteria andDiplomaNotBetween(String value1, String value2) {
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

        public Criteria andLocal_register_placeEqualTo(String value) {
            addCriterion("local_register_place =", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotEqualTo(String value) {
            addCriterion("local_register_place <>", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeGreaterThan(String value) {
            addCriterion("local_register_place >", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeGreaterThanOrEqualTo(String value) {
            addCriterion("local_register_place >=", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeLessThan(String value) {
            addCriterion("local_register_place <", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeLessThanOrEqualTo(String value) {
            addCriterion("local_register_place <=", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeLike(String value) {
            addCriterion("local_register_place like", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotLike(String value) {
            addCriterion("local_register_place not like", value, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeIn(List<String> values) {
            addCriterion("local_register_place in", values, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotIn(List<String> values) {
            addCriterion("local_register_place not in", values, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeBetween(String value1, String value2) {
            addCriterion("local_register_place between", value1, value2, "local_register_place");
            return (Criteria) this;
        }

        public Criteria andLocal_register_placeNotBetween(String value1, String value2) {
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

        public Criteria andIncomeEqualTo(String value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(String value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(String value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(String value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(String value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLike(String value) {
            addCriterion("income like", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotLike(String value) {
            addCriterion("income not like", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<String> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<String> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(String value1, String value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(String value1, String value2) {
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

        public Criteria andHouse_typeEqualTo(String value) {
            addCriterion("house_type =", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeGreaterThan(String value) {
            addCriterion("house_type >", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeLessThan(String value) {
            addCriterion("house_type <", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeLike(String value) {
            addCriterion("house_type like", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotLike(String value) {
            addCriterion("house_type not like", value, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeIn(List<String> values) {
            addCriterion("house_type in", values, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "house_type");
            return (Criteria) this;
        }

        public Criteria andHouse_typeNotBetween(String value1, String value2) {
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

        public Criteria andFixed_assetsEqualTo(String value) {
            addCriterion("fixed_assets =", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotEqualTo(String value) {
            addCriterion("fixed_assets <>", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsGreaterThan(String value) {
            addCriterion("fixed_assets >", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_assets >=", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsLessThan(String value) {
            addCriterion("fixed_assets <", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsLessThanOrEqualTo(String value) {
            addCriterion("fixed_assets <=", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsLike(String value) {
            addCriterion("fixed_assets like", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotLike(String value) {
            addCriterion("fixed_assets not like", value, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsIn(List<String> values) {
            addCriterion("fixed_assets in", values, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotIn(List<String> values) {
            addCriterion("fixed_assets not in", values, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsBetween(String value1, String value2) {
            addCriterion("fixed_assets between", value1, value2, "fixed_assets");
            return (Criteria) this;
        }

        public Criteria andFixed_assetsNotBetween(String value1, String value2) {
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

        public Criteria andEmploymentEqualTo(String value) {
            addCriterion("employment =", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotEqualTo(String value) {
            addCriterion("employment <>", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThan(String value) {
            addCriterion("employment >", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentGreaterThanOrEqualTo(String value) {
            addCriterion("employment >=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThan(String value) {
            addCriterion("employment <", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLessThanOrEqualTo(String value) {
            addCriterion("employment <=", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentLike(String value) {
            addCriterion("employment like", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotLike(String value) {
            addCriterion("employment not like", value, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentIn(List<String> values) {
            addCriterion("employment in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotIn(List<String> values) {
            addCriterion("employment not in", values, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentBetween(String value1, String value2) {
            addCriterion("employment between", value1, value2, "employment");
            return (Criteria) this;
        }

        public Criteria andEmploymentNotBetween(String value1, String value2) {
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

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
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

        public Criteria andProfession_levelEqualTo(String value) {
            addCriterion("profession_level =", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotEqualTo(String value) {
            addCriterion("profession_level <>", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelGreaterThan(String value) {
            addCriterion("profession_level >", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelGreaterThanOrEqualTo(String value) {
            addCriterion("profession_level >=", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelLessThan(String value) {
            addCriterion("profession_level <", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelLessThanOrEqualTo(String value) {
            addCriterion("profession_level <=", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelLike(String value) {
            addCriterion("profession_level like", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotLike(String value) {
            addCriterion("profession_level not like", value, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelIn(List<String> values) {
            addCriterion("profession_level in", values, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotIn(List<String> values) {
            addCriterion("profession_level not in", values, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelBetween(String value1, String value2) {
            addCriterion("profession_level between", value1, value2, "profession_level");
            return (Criteria) this;
        }

        public Criteria andProfession_levelNotBetween(String value1, String value2) {
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

        public Criteria andCur_hire_durationEqualTo(String value) {
            addCriterion("cur_hire_duration =", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotEqualTo(String value) {
            addCriterion("cur_hire_duration <>", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationGreaterThan(String value) {
            addCriterion("cur_hire_duration >", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationGreaterThanOrEqualTo(String value) {
            addCriterion("cur_hire_duration >=", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationLessThan(String value) {
            addCriterion("cur_hire_duration <", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationLessThanOrEqualTo(String value) {
            addCriterion("cur_hire_duration <=", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationLike(String value) {
            addCriterion("cur_hire_duration like", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotLike(String value) {
            addCriterion("cur_hire_duration not like", value, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationIn(List<String> values) {
            addCriterion("cur_hire_duration in", values, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotIn(List<String> values) {
            addCriterion("cur_hire_duration not in", values, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationBetween(String value1, String value2) {
            addCriterion("cur_hire_duration between", value1, value2, "cur_hire_duration");
            return (Criteria) this;
        }

        public Criteria andCur_hire_durationNotBetween(String value1, String value2) {
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

        public Criteria andSchooling_systemEqualTo(String value) {
            addCriterion("schooling_system =", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotEqualTo(String value) {
            addCriterion("schooling_system <>", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemGreaterThan(String value) {
            addCriterion("schooling_system >", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemGreaterThanOrEqualTo(String value) {
            addCriterion("schooling_system >=", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemLessThan(String value) {
            addCriterion("schooling_system <", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemLessThanOrEqualTo(String value) {
            addCriterion("schooling_system <=", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemLike(String value) {
            addCriterion("schooling_system like", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotLike(String value) {
            addCriterion("schooling_system not like", value, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemIn(List<String> values) {
            addCriterion("schooling_system in", values, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotIn(List<String> values) {
            addCriterion("schooling_system not in", values, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemBetween(String value1, String value2) {
            addCriterion("schooling_system between", value1, value2, "schooling_system");
            return (Criteria) this;
        }

        public Criteria andSchooling_systemNotBetween(String value1, String value2) {
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

        public Criteria andRefund_verdictIsNull() {
            addCriterion("refund_verdict is null");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictIsNotNull() {
            addCriterion("refund_verdict is not null");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictEqualTo(String value) {
            addCriterion("refund_verdict =", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictNotEqualTo(String value) {
            addCriterion("refund_verdict <>", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictGreaterThan(String value) {
            addCriterion("refund_verdict >", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictGreaterThanOrEqualTo(String value) {
            addCriterion("refund_verdict >=", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictLessThan(String value) {
            addCriterion("refund_verdict <", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictLessThanOrEqualTo(String value) {
            addCriterion("refund_verdict <=", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictLike(String value) {
            addCriterion("refund_verdict like", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictNotLike(String value) {
            addCriterion("refund_verdict not like", value, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictIn(List<String> values) {
            addCriterion("refund_verdict in", values, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictNotIn(List<String> values) {
            addCriterion("refund_verdict not in", values, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictBetween(String value1, String value2) {
            addCriterion("refund_verdict between", value1, value2, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andRefund_verdictNotBetween(String value1, String value2) {
            addCriterion("refund_verdict not between", value1, value2, "refund_verdict");
            return (Criteria) this;
        }

        public Criteria andUmpireIsNull() {
            addCriterion("umpire is null");
            return (Criteria) this;
        }

        public Criteria andUmpireIsNotNull() {
            addCriterion("umpire is not null");
            return (Criteria) this;
        }

        public Criteria andUmpireEqualTo(String value) {
            addCriterion("umpire =", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireNotEqualTo(String value) {
            addCriterion("umpire <>", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireGreaterThan(String value) {
            addCriterion("umpire >", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireGreaterThanOrEqualTo(String value) {
            addCriterion("umpire >=", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireLessThan(String value) {
            addCriterion("umpire <", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireLessThanOrEqualTo(String value) {
            addCriterion("umpire <=", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireLike(String value) {
            addCriterion("umpire like", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireNotLike(String value) {
            addCriterion("umpire not like", value, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireIn(List<String> values) {
            addCriterion("umpire in", values, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireNotIn(List<String> values) {
            addCriterion("umpire not in", values, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireBetween(String value1, String value2) {
            addCriterion("umpire between", value1, value2, "umpire");
            return (Criteria) this;
        }

        public Criteria andUmpireNotBetween(String value1, String value2) {
            addCriterion("umpire not between", value1, value2, "umpire");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictIsNull() {
            addCriterion("first_trial_verdict is null");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictIsNotNull() {
            addCriterion("first_trial_verdict is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictEqualTo(String value) {
            addCriterion("first_trial_verdict =", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictNotEqualTo(String value) {
            addCriterion("first_trial_verdict <>", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictGreaterThan(String value) {
            addCriterion("first_trial_verdict >", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictGreaterThanOrEqualTo(String value) {
            addCriterion("first_trial_verdict >=", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictLessThan(String value) {
            addCriterion("first_trial_verdict <", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictLessThanOrEqualTo(String value) {
            addCriterion("first_trial_verdict <=", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictLike(String value) {
            addCriterion("first_trial_verdict like", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictNotLike(String value) {
            addCriterion("first_trial_verdict not like", value, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictIn(List<String> values) {
            addCriterion("first_trial_verdict in", values, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictNotIn(List<String> values) {
            addCriterion("first_trial_verdict not in", values, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictBetween(String value1, String value2) {
            addCriterion("first_trial_verdict between", value1, value2, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_trial_verdictNotBetween(String value1, String value2) {
            addCriterion("first_trial_verdict not between", value1, value2, "first_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andFirst_personIsNull() {
            addCriterion("first_person is null");
            return (Criteria) this;
        }

        public Criteria andFirst_personIsNotNull() {
            addCriterion("first_person is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_personEqualTo(String value) {
            addCriterion("first_person =", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personNotEqualTo(String value) {
            addCriterion("first_person <>", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personGreaterThan(String value) {
            addCriterion("first_person >", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personGreaterThanOrEqualTo(String value) {
            addCriterion("first_person >=", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personLessThan(String value) {
            addCriterion("first_person <", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personLessThanOrEqualTo(String value) {
            addCriterion("first_person <=", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personLike(String value) {
            addCriterion("first_person like", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personNotLike(String value) {
            addCriterion("first_person not like", value, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personIn(List<String> values) {
            addCriterion("first_person in", values, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personNotIn(List<String> values) {
            addCriterion("first_person not in", values, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personBetween(String value1, String value2) {
            addCriterion("first_person between", value1, value2, "first_person");
            return (Criteria) this;
        }

        public Criteria andFirst_personNotBetween(String value1, String value2) {
            addCriterion("first_person not between", value1, value2, "first_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictIsNull() {
            addCriterion("recheck_verdict is null");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictIsNotNull() {
            addCriterion("recheck_verdict is not null");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictEqualTo(String value) {
            addCriterion("recheck_verdict =", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictNotEqualTo(String value) {
            addCriterion("recheck_verdict <>", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictGreaterThan(String value) {
            addCriterion("recheck_verdict >", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictGreaterThanOrEqualTo(String value) {
            addCriterion("recheck_verdict >=", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictLessThan(String value) {
            addCriterion("recheck_verdict <", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictLessThanOrEqualTo(String value) {
            addCriterion("recheck_verdict <=", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictLike(String value) {
            addCriterion("recheck_verdict like", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictNotLike(String value) {
            addCriterion("recheck_verdict not like", value, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictIn(List<String> values) {
            addCriterion("recheck_verdict in", values, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictNotIn(List<String> values) {
            addCriterion("recheck_verdict not in", values, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictBetween(String value1, String value2) {
            addCriterion("recheck_verdict between", value1, value2, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_verdictNotBetween(String value1, String value2) {
            addCriterion("recheck_verdict not between", value1, value2, "recheck_verdict");
            return (Criteria) this;
        }

        public Criteria andRecheck_personIsNull() {
            addCriterion("recheck_person is null");
            return (Criteria) this;
        }

        public Criteria andRecheck_personIsNotNull() {
            addCriterion("recheck_person is not null");
            return (Criteria) this;
        }

        public Criteria andRecheck_personEqualTo(String value) {
            addCriterion("recheck_person =", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personNotEqualTo(String value) {
            addCriterion("recheck_person <>", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personGreaterThan(String value) {
            addCriterion("recheck_person >", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personGreaterThanOrEqualTo(String value) {
            addCriterion("recheck_person >=", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personLessThan(String value) {
            addCriterion("recheck_person <", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personLessThanOrEqualTo(String value) {
            addCriterion("recheck_person <=", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personLike(String value) {
            addCriterion("recheck_person like", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personNotLike(String value) {
            addCriterion("recheck_person not like", value, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personIn(List<String> values) {
            addCriterion("recheck_person in", values, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personNotIn(List<String> values) {
            addCriterion("recheck_person not in", values, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personBetween(String value1, String value2) {
            addCriterion("recheck_person between", value1, value2, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andRecheck_personNotBetween(String value1, String value2) {
            addCriterion("recheck_person not between", value1, value2, "recheck_person");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictIsNull() {
            addCriterion("last_trial_verdict is null");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictIsNotNull() {
            addCriterion("last_trial_verdict is not null");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictEqualTo(String value) {
            addCriterion("last_trial_verdict =", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictNotEqualTo(String value) {
            addCriterion("last_trial_verdict <>", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictGreaterThan(String value) {
            addCriterion("last_trial_verdict >", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictGreaterThanOrEqualTo(String value) {
            addCriterion("last_trial_verdict >=", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictLessThan(String value) {
            addCriterion("last_trial_verdict <", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictLessThanOrEqualTo(String value) {
            addCriterion("last_trial_verdict <=", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictLike(String value) {
            addCriterion("last_trial_verdict like", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictNotLike(String value) {
            addCriterion("last_trial_verdict not like", value, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictIn(List<String> values) {
            addCriterion("last_trial_verdict in", values, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictNotIn(List<String> values) {
            addCriterion("last_trial_verdict not in", values, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictBetween(String value1, String value2) {
            addCriterion("last_trial_verdict between", value1, value2, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_trial_verdictNotBetween(String value1, String value2) {
            addCriterion("last_trial_verdict not between", value1, value2, "last_trial_verdict");
            return (Criteria) this;
        }

        public Criteria andLast_personIsNull() {
            addCriterion("last_person is null");
            return (Criteria) this;
        }

        public Criteria andLast_personIsNotNull() {
            addCriterion("last_person is not null");
            return (Criteria) this;
        }

        public Criteria andLast_personEqualTo(String value) {
            addCriterion("last_person =", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personNotEqualTo(String value) {
            addCriterion("last_person <>", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personGreaterThan(String value) {
            addCriterion("last_person >", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personGreaterThanOrEqualTo(String value) {
            addCriterion("last_person >=", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personLessThan(String value) {
            addCriterion("last_person <", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personLessThanOrEqualTo(String value) {
            addCriterion("last_person <=", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personLike(String value) {
            addCriterion("last_person like", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personNotLike(String value) {
            addCriterion("last_person not like", value, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personIn(List<String> values) {
            addCriterion("last_person in", values, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personNotIn(List<String> values) {
            addCriterion("last_person not in", values, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personBetween(String value1, String value2) {
            addCriterion("last_person between", value1, value2, "last_person");
            return (Criteria) this;
        }

        public Criteria andLast_personNotBetween(String value1, String value2) {
            addCriterion("last_person not between", value1, value2, "last_person");
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