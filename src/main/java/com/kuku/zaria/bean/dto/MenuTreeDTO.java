package com.kuku.zaria.bean.dto;

import com.kuku.zaria.bean.MenuTree;
import lombok.Data;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Data
public class MenuTreeDTO extends BaseDTO {

    private List<MenuTree> menuTreeList;

    public MenuTreeDTO() {
    }

    public MenuTreeDTO(List<MenuTree> menuTreeList) {
        this.menuTreeList = menuTreeList;
    }
}
