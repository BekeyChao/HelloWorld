/**
 * Created by hp on 2017/10/17.
 */
//import calendar from 'calendar.js'
class iCalendar {
    /**
     * @param args number 年(1990-2100) or object 保存年月日农历等信息的参数 or Date
     * @param month number 月(1-12) 默认1
     * @param day number 日(1-31) 默认1
     * @param lunar boolean 是否农历 默认false
     * @param isLeapMonth boolean 是否闰月 默认false
     */
    constructor(args, month=1, day=1, lunar = false, isLeapMonth = false) {
        let year = args
        //通过prop构造
        if(typeof args === 'object' &&'year','month','day' in args){
            year = args.year
            month = args.month
            day = args.day
            lunar = args.lunar
            isLeapMonth = args.isLeapMonth
        }
        //通过Date构造
        if(args instanceof Date) {
            year = args.getFullYear()
            month = args.getMonth() + 1
            day = args.getDate()
            lunar = false
            isLeapMonth = false
        }
        let _calendar
        //
        if(lunar) {
            _calendar = calendar.lunar2solar(year, month, day, isLeapMonth)
        }else{
            _calendar = calendar.solar2lunar(year, month, day)
        }

        //构造一个农历
        this._lunarCalendar = new LunarCalendar(_calendar.lYear, _calendar.lMonth, _calendar.lDay,
            _calendar.isToday, _calendar.isTerm, _calendar.Term,  _calendar.isLeap, _calendar.Animal, this)
        //构造一个公历
        this._gregorianCalendar = new GregorianCalendar(_calendar.cYear, _calendar.cMonth, _calendar.cDay,
            _calendar.isToday, _calendar.isTerm, _calendar.Term, _calendar.nWeek, _calendar.astro, this)
    }

    /**
     * 获取农历数据
     * @returns {LunarCalendar}
     */
    getLunarCalendar() {
        return this._lunarCalendar
    }

    /**
     * 获取公历数据
     * @returns {GregorianCalendar}
     */
    getGregorianCalendar() {
        return this._gregorianCalendar
    }


    /**
     * 浅复制 类似于 $.extend()
     * @param target
     * @param options
     * @returns {*}
     * @private
     */
    static _extend(target, options = {}) {
        if(typeof options !== "object")
            throw "请传入一个对象" + options;
        for(let name in options){
            target[name] = options[name]
        }
        return target
    }

}

class BaseCalendar {
    /*
    _year    //年
    _month   //月
    _dayOfMonth    //日
    _isToday //是否是今天
    _isTerm  //是否是节气
    _term    //节气
    */

    constructor(year, month, dayOfMonth, isToday, isTerm, term, parent = null) {
        if(new.target === BaseCalendar)
            throw new Error("本类不能实例化")
        this._year = year;
        this._month = month;
        this._dayOfMonth = dayOfMonth;
        this._isToday = isToday;
        this._isTerm = isTerm;
        this._term = term;
        this._parent = parent
    }

    getYear() {
        return this._year;
    }

    getMonth() {
        return this._month;
    }

    getDayOfMonth() {
        return this._dayOfMonth;
    }

    isToday() {
        return this._isToday;
    }

    isTerm() {
        return this._isTerm;
    }

    getTerm() {
        return this._term;
    }
}

class LunarCalendar extends BaseCalendar {
    /*
    _animal //生肖
    _isLeapMonth    //是否为闰月
    */
    constructor(year, month, dayOfMonth, isToday, isTerm, term, isLeapMonth, animal, parent = null) {
        super(year, month, dayOfMonth, isToday, isTerm, term, parent)
        this._isLeapMonth = isLeapMonth
        this._animal = animal;
    }

    /**
     * 返回今年的生肖
     * @returns {*}
     */
    geAnimal() {
        return this._animal;
    }

    /**
     * 返回本日期是否为闰月
     * @returns {*}
     */
    isLeapMonth() {
        return this._isLeapMonth
    }

    /**
     * 返回今年农历有多少天
     * @returns {*|Number}
     */
    getMaxDaysOfYear() {
        return calendar.lYearDays(this.getYear())
    }

    /**
     * @returns {GregorianCalendar}
     */
    toGergorianCalendar() {
        if(this._parent && this._parent instanceof iCalendar)
            return this._parent.getGregorianCalendar()
        return new iCalendar(this.getYear(),this.getMonth(),this.getDayOfMonth(),
            true,this.isLeapMonth()).getGregorianCalendar()
    }

    /**
     * 返回js的Date
     * @returns {Date}
     */
    toLocalDate() {
        return this.toGergorianCalendar().toLocalDate()
    }

}

class GregorianCalendar extends BaseCalendar {
    /*
    _dayOfWeek   //星期
    _astro  //星座
    */

    constructor(year, month, dayOfMonth, isToday,  isTerm, term, dayOfWeek, astro, parent = null) {
        super(year, month, dayOfMonth, isToday,  isTerm, term, parent)
        this._dayOfWeek = dayOfWeek
        this._astro = astro
    }

    getDayOfWeek() {
        return this._dayOfWeek;
    }

    /**
     * @returns {LunarCalendar}
     */
    toLunarCalendar() {
        if(this._parent && this._parent instanceof iCalendar)
            return this._parent.getLunarCalendar();
        return new iCalendar(this.getYear(),
            this.getMonth(),this.getDayOfMonth()).getLunarCalendar()
    }

    /**
     * 返回js的Date
     * @returns {Date}
     */
    toLocalDate() {
        return new Date(this.getYear(), this.getMonth() - 1, this.getDayOfMonth())
    }
}
