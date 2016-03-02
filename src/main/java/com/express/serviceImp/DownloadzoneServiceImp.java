package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.Downloadzone;
import com.express.service.BaseService;
import com.express.service.DownloadzoneService;

@Service
public class DownloadzoneServiceImp extends BaseService implements DownloadzoneService{

	@Override
	public List<Downloadzone> getFileList() {
		return getDownloadzoneDao().getFileList();
	}

	@Override
	public Downloadzone getById(String id) {
		return getDownloadzoneDao().getById(id);
	}

	@Override
	public boolean addDownloadzone(Downloadzone downloadzone) {
		return getDownloadzoneDao().addDownloadzone(downloadzone);
	}

	@Override
	public boolean updateDownloadzone(Downloadzone downloadzone) {
		return getDownloadzoneDao().updateDownloadzone(downloadzone);
	}

	@Override
	public boolean deleteDownloadzone(String id) {
		return getDownloadzoneDao().deleteDownloadzone(id);
	}

}
