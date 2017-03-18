package com.hdaheizi.base.fight.fsm.buff;

import com.hdaheizi.base.fight.fsm.AbstractGameState;
import com.hdaheizi.base.fight.skill.FightSkill;
import com.hdaheizi.base.fight.unit.DefaultAIUnit;
import com.hdaheizi.base.util.MessageFormatter;

/**
 * 通用buff抽象类
 * @author daheiz
 * @Date 2016年5月22日 下午5:14:08
 */
public abstract class CommBuff extends AbstractGameState implements Buff {

	/** buff类型 1-增益 2-减益 3-控制*/
	protected int type;

	/** 优先级 */
	protected float priority;

	/** 产生buff的来源 */
	protected FightSkill skill;


	/**
	 * 构造函数
	 * @param buffName buff名称
	 * @param hero 拥有buff的AI
	 * @param skill 产生buff的来源
	 * @param type buff类型
	 * @param priority buff 优先级
	 */
	public CommBuff(String buffName, DefaultAIUnit hero, FightSkill skill, int type, float priority) {	
		super(buffName, hero);
		this.priority = priority;
		this.type = type;
		this.skill = skill;
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#getType()
	 */
	@Override
	public int getType(){
		return this.type;
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#getPriority()
	 */
	@Override
	public float getPriority(){
		return this.priority;
	}

	/**
	 * @see com.hdaheizi.base.fight.fsm.AbstractGameState#onEnter()
	 */
	@Override
	public void onEnter(){
		super.onEnter();
		hero.room.notifyMsg(MessageFormatter.format("{0}|{1}|enter", hero.id, name));
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.GameState#onExit()
	 */
	@Override
	public void onExit(){
		super.onExit();
		hero.room.notifyMsg(MessageFormatter.format("{0}|{1}|exit", hero.id, name));
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#mixBuff(com.hdaheizi.base.fight.fsm.buff.Buff)
	 */
	@Override
	public boolean mixBuff(Buff buff) {
		if(name.equals(buff.getName())){
			hero.removeBuff(this);
			hero.addBuff(buff);
			return true;
		}
		return false;
	}


	/**
	 * double 转为 int
	 * @param value
	 * @return
	 * @Date 2016年7月13日 上午12:55:15
	 */
	protected static int doubleToInt(Object value){
		return ((Double) value).intValue();
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#getSourceSkill()
	 */
	@Override
	public FightSkill getSourceSkill() {
		return skill;
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#getSourceHero()
	 */
	@Override
	public DefaultAIUnit getSourceHero() {
		return hero;
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#succAttack(com.hdaheizi.base.fight.unit.DefaultAIUnit, com.hdaheizi.base.fight.unit.DefaultAIUnit, int, java.lang.StringBuilder, java.lang.Object)
	 */
	@Override
	public boolean succAttack(DefaultAIUnit att, DefaultAIUnit def,
			int attType, StringBuilder inner, Object source) {
		return true;
	}


	/**
	 * @see com.hdaheizi.base.fight.fsm.buff.Buff#calcDam(int, com.hdaheizi.base.fight.unit.DefaultAIUnit, com.hdaheizi.base.fight.unit.DefaultAIUnit, int, java.lang.StringBuilder, java.lang.Object)
	 */
	@Override
	public int calcDam(int dam, DefaultAIUnit att, DefaultAIUnit def,
			int attType, StringBuilder inner, Object source) {
		return dam;
	}
}
