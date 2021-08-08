package com.sankdev.service;

import com.sankdev.dao.PortfolioDAO;
import com.sankdev.portfolio.Item;
import java.util.List;

public class PortfolioService {

  private PortfolioDAO portfolioDAO;

  public PortfolioService() {
    this.portfolioDAO = new PortfolioDAO();
  }

  public List<Item> getItems() {
    return this.portfolioDAO.getItems();
  }

}