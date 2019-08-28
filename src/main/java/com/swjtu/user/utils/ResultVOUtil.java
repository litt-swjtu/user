package com.swjtu.user.utils;

import com.swjtu.user.vo.ResultVO;
import lombok.Data;

/**
 * @author 李天峒
 * @date 2019/4/11 23:28
 */
@Data
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return ResultVOUtil.success(null);
    }

    /**
     * 结果错误返回
     * @param code 错误代码
     * @param msg  错误信息
     * @return
     */
    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        resultVO.setData(null);
        return  resultVO;
    }
}
