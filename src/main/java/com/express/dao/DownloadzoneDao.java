package com.express.dao;

import java.util.List;

import com.express.bean.Downloadzone;

public interface DownloadzoneDao {

	/* 查询表中文件列表 */
	public List<Downloadzone> getFileList();

	/* 根据id查询指定文件 */
	public Downloadzone getById(String id);

	/* 添加文件 */
	public boolean addDownloadzone(Downloadzone downloadzone);

	/* 更新文件 */
	public boolean updateDownloadzone(Downloadzone downloadzone);

	/* 删除文件 */
	public boolean deleteDownloadzone(String id);

}
