import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class JavaBeanObj implements Serializable {

    private int id;
    private String name;
    private Date dateOfCreation;
    private boolean isFine;

    public JavaBeanObj withId(int id){
       this.id = id;
       return this;
    }

    public JavaBeanObj withName(String name){
        this.name = name;
        return this;
    }

    public JavaBeanObj withDate(Date date){
        this.dateOfCreation = date;
        return this;
    }

    public JavaBeanObj withFine(boolean isFine){
        this.isFine = isFine;
        return this;
    }

}
