package top.daheizi.commons.fight.event;


/**
 * 战斗事件的抽象类
 * @author daheizi
 * @Date 2016年4月5日 上午2:40:31
 */
public abstract class FightEvent{

    /** 发送延时(ms) */
    public int delay = 0;

    /** 是否失效 */
    public boolean isExpire = false;

}
