package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.News;
import com.express.dao.BaseDao;
import com.express.dao.NewsDao;
import com.express.query.NewsQuery;

@Repository
public class NewsDaoImp extends BaseDao implements NewsDao{
	
	private static final Logger logger = Logger.getLogger(NewsDaoImp.class);  

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsType(int newstype) {
		List<News> news = null;
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsType", newstype);
		} catch (Exception e) {
			logger.error("根据新闻类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news; 
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		newsQuery.setSubtype(subtype);
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndSubType", newsQuery);
		} catch (Exception e) {
			logger.error("根据新闻类型和子类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	public News getByNewsId(String newsid) {
		News news = null;
		try {
			news = (News) getSqlMapClientTemplate().queryForObject("getByNewsId",newsid);
		} catch (Exception e) {
			logger.error("根据新闻id获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news; 
	}

	public boolean addNews(News news) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addNews", news);
		} catch (Exception e) {
			logger.error("添加新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateNews(News news) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateNews", news);
		} catch (Exception e) {
			logger.error("更新新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteNews(String newsid) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteNews", newsid);
		} catch (Exception e) {
			logger.error("删除新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
