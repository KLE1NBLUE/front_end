package com.zane.service;

import com.zane.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zane.vo.BarVO;
import com.zane.vo.PieVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-04-03
 */
public interface FruitService extends IService<Fruit> {
    public BarVO BarVOList();
    public List<PieVO> PieVOList();
}
