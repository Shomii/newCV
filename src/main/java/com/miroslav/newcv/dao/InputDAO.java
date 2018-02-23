
package com.miroslav.newcv.dao;

import com.miroslav.newcv.domain.Input;
import java.util.List;

public interface InputDAO {
    
     public void savingCV(Input input);
    
     public void updateCV(Input input);
     
     public Input getCVId(Integer cvID);
     
     public List<Input> allCVs();
     
     public void deleteCV(Input input);
}
