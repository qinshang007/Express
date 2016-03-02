package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.News;
import com.express.service.BaseService;
import com.express.service.NewsService;

@Service
public class NewsServiceImp extends BaseService implements NewsService {

	
	public List<News> getNewsListByNewsType(int newstype) {
		return getNewsDao().getNewsListByNewsType(newstype);
	}

	public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype) {
		return getNewsDao().getNewsListByNewsTypeAndSubType(newstype, subtype);
	}

	public News getByNewsId(String newsid) {
		return getNewsDao().getByNewsId(newsid);
	}

	public boolean addNews(News news) {
		if(getNewsDao().addNews(news))
			return true;
		else
			return false;
	}

	public boolean updateNews(News news) {
		if(getNewsDao().updateNews(news))
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteNews(String newsid) {
		return getNewsDao().deleteNews(newsid);
	}

}
