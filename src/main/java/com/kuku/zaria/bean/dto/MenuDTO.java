package com.kuku.zaria.bean.dto;

import com.kuku.zaria.domain.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-21
 */
@Data
public class MenuDTO extends BaseDTO {

    private List<Menu> menuList;

    public MenuDTO(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
