package com.data.dataproject.dto.map;


import com.data.dataproject.domain.LocalFood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapDto {
    private List<LocalFood> localFoodList;
}
