package top.daheizi.commons.fight.fsm.buff;

import top.daheizi.commons.fight.common.FightConstants;
import top.daheizi.commons.fight.skill.FightSkill;
import top.daheizi.commons.fight.unit.DefaultAIUnit;

/**
 * buff工厂
 * @author daheizi
 * @Date 2016年5月22日 下午5:11:27
 */
public class BuffFactory {

    /**
     * 创建buff
     * @param buffName
     * @param hero
     * @param skill
     * @param params
     * @return
     * @Date 2016年7月10日 下午10:05:09
     */
    public static Buff createBuff(
            String buffName, 
            DefaultAIUnit hero, 
            FightSkill skill, 
            Object... params){

        switch(buffName){
        case "huoyan":
            return new DDamBuff(buffName, hero, skill, FightConstants.BUFF_TYPE_DEBUFF, 1f, params);
        case "dingshen":
        case "xuanyun":
            return new XuanyunBuff(buffName, hero, skill, FightConstants.BUFF_TYPE_CONTROL, 1.1f, params);
        default:
            return null;
        }


    }
}
