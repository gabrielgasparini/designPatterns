package ifsp.pwe.ManagedBeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteManagedBean {
    public String getHorario(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

        System.err.println("Hehe");

        return "Atualizado agora em " + sdf.format(new Date());
    }
}