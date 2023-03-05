package hut.natsufumij.util.bean;

import lombok.Data;

import java.util.List;

@Data
public class QueryMBase extends PageableModel{
    private Long id;
    private List<Long> ids;
}
