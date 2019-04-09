package edu.eat.order.base.example;

import java.util.ArrayList;
import java.util.List;

public class Example {

    protected boolean distinct;

    protected String orderByClause = null;

    protected String groupByClause = null;

    protected List<Criteria> oredCriteria;



    private Example() {
        oredCriteria = new ArrayList<Criteria>();
        oredCriteria.add(criteria);
    }

    public String getGroupByClause() {
        return groupByClause;
    }


    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
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

    Criteria criteria = createCriteriaInternal();

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        groupByClause = null;
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
            if (condition.startsWith("null")) {
                return;
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            if (property == null) {
                return;
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIsNull(String property) {
            addCriterion(property + " is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNull(String property) {
            addCriterion(property + " is not null");
            return (Criteria) this;
        }

        public Criteria andEqualTo(String property, Object value) {
            addCriterion(property + " =", value, property);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String property, Object value) {
            addCriterion(property + " <>", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String property, Object value) {
            addCriterion(property + " >", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String property, Object value) {
            addCriterion(property + " >=", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThan(String property, Object value) {
            addCriterion(property + " <", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String property, Object value) {
            addCriterion(property + " <=", value, property);
            return (Criteria) this;
        }

        public Criteria andIn(String property, List<?> values) {
            addCriterion(property + " in", values, property);
            return (Criteria) this;
        }

        public Criteria andNotIn(String property, List<?> values) {
            addCriterion(property + " not in", values, property);
            return (Criteria) this;
        }

        public Criteria andBetween(String property, Object value1, Object value2) {
            addCriterion(property + " between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String property, Object value1, Object value2) {
            addCriterion(property + " not between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria andLike(String property, String value) {
            addCriterion(property + "  like", value, property);
            return (Criteria) this;
        }

        public Criteria andNotLike(String property, String value) {
            addCriterion(property + "  not like", value, property);
            return (Criteria) this;
        }

        /**
         * 手写条件
         *
         * @param condition 例如 "length(countryname)<5"
         * @return
         */
        public Criteria andCondition(String condition) {
            addCriterion(condition);
            return (Criteria) this;
        }

        /**
         * 手写左边条件，右边用value值
         *
         * @param condition 例如 "length(countryname)="
         * @param value     例如 5
         * @return
         */
        public Criteria andCondition(String condition, Object value) {
            criteria.add(new Criterion(condition, value));
            return (Criteria) this;
        }

        /**
         * 手写左边条件，右边用value值
         *
         * @param condition   例如 "length(countryname)="
         * @param value       例如 5
         * @param typeHandler 类型处理
         * @return
         */
        public Criteria andCondition(String condition, Object value, String typeHandler) {
            criteria.add(new Criterion(condition, value, typeHandler));
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
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
    }


    /**
     * 拼接条件
     */
    public static Example getInstance() {
        return new Example();
    }

    private Example addParam(String key, Object value1, Object value2, ExampleType.Operation operation, List<?> values) {
        if (values == null && (value1 == null || value1.equals(""))) {
            return this;
        }
        if (key == null || key.isEmpty()) {
        } else {
            switch (operation) {
                case EQ:
                    criteria.andEqualTo(key, value1);
                    break;
                case NOTEQ:
                    criteria.andNotEqualTo(key, value1);
                    break;
                case BETWEEN:
                    criteria.andBetween(key, value1, value2);
                    break;
                case GT:
                    criteria.andGreaterThan(key, value1);
                    break;
                case GTE:
                    criteria.andGreaterThanOrEqualTo(key, value1);
                    break;
                case LT:
                    criteria.andLessThan(key, value1);
                    break;
                case LTE:
                    criteria.andLessThanOrEqualTo(key, value1);
                    break;
                case LIKE:
                    criteria.andCondition(key + " like '%" + value1 + "%'");
                    break;
                case IN:
                    criteria.andIn(key, values);
                    break;
                case NOTIN:
                    criteria.andNotIn(key, values);
                    break;
                case ISNULL:
                    criteria.andIsNull(key);
                    break;
                case ISNOTNULL:
                    criteria.andIsNotNull(key);
                    break;
                default:
                    break;
            }
        }
        return this;
    }

    /**
     * @param condition
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 上午11:53:57
     * @TODO 添加条件   手写
     */
    public Example addParam(String condition) {
        criteria.andCondition(condition);
        return this;
    }

    /**
     * @param key
     * @param value
     * @param operation
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 上午11:51:06
     * @TODO 添加条件
     */
    public Example addParam(String key, Object value, ExampleType.Operation operation) {
        addParam(key, value, null, operation, null);
        return this;
    }

    /**
     * @param key
     * @param value
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 上午11:50:36
     * @TODO 添加条件   默认是等于
     */
    public Example addParam(String key, Object value) {
        addParam(key, value, null, ExampleType.Operation.EQ, null);
        return this;
    }

    /**
     * @param key
     * @param value1
     * @param value2
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 上午11:53:26
     * @TODO 添加条件  要在两个值中间
     */
    public Example addParam(String key, Object value1, Object value2) {
        addParam(key, value1, value2, ExampleType.Operation.BETWEEN, null);
        return this;
    }

    /**
     * @param key
     * @param values
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 下午12:15:11
     * @TODO 添加条件  in或者notin
     */
    public Example addParam(String key, List<?> values, ExampleType.Operation operation) {
        addParam(key, null, null, operation, values);
        return this;
    }

    /**
     * @param key
     * @param operation
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 下午12:20:25
     * @TODO 添加条件   isnull  或者 isnotnull
     */
    public Example addParam(String key, ExampleType.Operation operation) {
        addParam(key, null, null, operation, null);
        return this;
    }

    /**
     * @param order
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 下午12:21:30
     * @TODO 添加排序
     */
    public Example addOrder(String order, ExampleType.OrderType orderType) {
        String orderTemp = getOrderByClause();
        orderTemp = orderTemp == null ? "" : orderTemp + " ,";
        setOrderByClause(orderTemp + " " + order + " " + orderType.toString());
        return this;
    }

    /**
     * @param order
     * @return Example
     * @Author 执笔
     * @Date 2016年1月6日 下午12:24:36
     * @TODO TODO
     */
    public Example addOrder(String order) {
        setOrderByClause(order + " ASC");
        return this;
    }

    /**
     * 添加分组
     *
     * @param group
     * @return
     */
    public Example addGroup(String group) {
        setGroupByClause(group);
        return this;
    }


    /**
     * @param example
     * @Author 执笔
     * @Date 2016年1月6日 下午12:59:16
     * @TODO 添加or语句
     */
    public Example addOr(Example example) {
        for (Criteria criteria : example.getOredCriteria()) {
            or(criteria);
        }
        return this;
    }

}
