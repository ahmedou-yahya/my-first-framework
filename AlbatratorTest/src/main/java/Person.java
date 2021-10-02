import annotations.Max;
import annotations.Min;
import annotations.Null;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Person {

    @Min @Null(false) @Max
    private String name;
    @Min @Max
    private int age;
    @Min @Null(false) @Max
    private String profession;

    public Person(String name){
        this.name=name;

    }
}
