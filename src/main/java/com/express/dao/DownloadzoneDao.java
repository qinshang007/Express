package com.express.dao;

import java.util.List;

import com.express.bean.Downloadzone;

public interface DownloadzoneDao {

	/* ��ѯ�����ļ��б� */
	public List<Downloadzone> getFileList();

	/* ����id��ѯָ���ļ� */
	public Downloadzone getById(String id);

	/* ����ļ� */
	public boolean addDownloadzone(Downloadzone downloadzone);

	/* �����ļ� */
	public boolean updateDownloadzone(Downloadzone downloadzone);

	/* ɾ���ļ� */
	public boolean deleteDownloadzone(String id);

}
