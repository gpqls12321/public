package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.ProductDTO;

public class ProductDAO {

	private ProductDAO() {

	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

//	SELECT p_code,
//		   p_name,
//		   p_price2,
//		   p_img
//	FROM (SELECT rownum,
//				 p_code,
//				 p_name,
//				 p_price2,
//				 p_img
//		  FROM product
//		  WHERE p_bestyn = 'y'
//		  ORDER By p_indate desc)
//	WHERE rownum <= 4;

	public ArrayList<ProductDTO> listNewProduct() {
		ArrayList<ProductDTO> newProductList = new ArrayList<ProductDTO>();

		// 신상품 추출 sql
		String sql = "SELECT * FROM new_pro_view";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO product = new ProductDTO();

				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));

				newProductList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return newProductList;
	}

	public ArrayList<ProductDTO> listBestProduct() {
		ArrayList<ProductDTO> bestProductList = new ArrayList<ProductDTO>();

		String sql = "SELECT * FROM best_pro_view";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO product = new ProductDTO();

				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));

				bestProductList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return bestProductList;
	}

	public ProductDTO detailProduct(String p_code) {
		String sql = "SELECT * FROM product WHERE p_code = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductDTO product = new ProductDTO();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return product;
	}

}
