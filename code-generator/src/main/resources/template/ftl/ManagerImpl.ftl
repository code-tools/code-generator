package ${managerImplCfg.packageQualifiedName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${daoCfg.packageQualifiedName}.${daoCfg.className};
import ${managerCfg.packageQualifiedName}.${managerCfg.className};
import ${voCfg.packageQualifiedName}.${voCfg.className};
import com.jumbo.tmalloms.manager.BaseManagerImpl;

/**
 * @author ${clazzCmt.author}
 * @date ${clazzCmt.date}
 */
@Service("${managerCfg.className?uncap_first}")
@Transactional
public class ${managerImplCfg.className} extends BaseManagerImpl implements ${managerCfg.className} {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ${daoCfg.className} ${daoCfg.className?uncap_first};

	@Override
	public ${voCfg.className} initPage(Long ouId) {
		// TODO Auto-generated method stub
		return null;
	}

}
