package com.zane.service.impl;

import com.sun.org.apache.bcel.internal.generic.DUP;
import com.zane.entity.Fruit;
import com.zane.mapper.FruitMapper;
import com.zane.service.FruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zane.util.DataUtil;
import com.zane.vo.BarVO;
import com.zane.vo.DataVO;
import com.zane.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-04-03
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public BarVO BarVOList() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<DataVO> values = new ArrayList<>();
        //先查数据
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit:fruits
             ) {
            names.add(fruit.getName());
            DataVO dataVO = new DataVO();
            dataVO.setValue(fruit.getSale());
            dataVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            values.add(dataVO);
        }
        barVO.setNames(names);
        barVO.setValues(values);
        //转换VO return null;
        return barVO;
    }

    @Override
    public List<PieVO> PieVOList() {
        List<PieVO> pieVOList = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for (Fruit fruit:fruits) {
            PieVO pieVO = new PieVO();
            pieVO.setValue(fruit.getSale());
            pieVO.setName(fruit.getName());
            pieVO.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            pieVOList.add(pieVO);
        }
        return pieVOList;
    }
}
