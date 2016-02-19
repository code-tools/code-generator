package ${clazzCfg.packageQualifiedName};

import ${classVo.packageQualifiedName}.${classVo.className};
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author ${clazzCmt.author}
 * @date ${clazzCmt.date}
 */
public interface ${clazzCfg.className} extends BaseManager {

	/**
	 * 初始化页面
	 * @author ${clazzCmt.author}
	 * @date ${clazzCmt.date}
	 * @param ouId
	 * @return
	 */
	public ${classVo.className} initPage(Long ouId);
	
}
