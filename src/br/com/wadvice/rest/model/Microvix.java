package br.com.wadvice.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Microvix")
public class Microvix {
	
	private ResponseData ResponseDataObject;
	private ResponseResult ResponseResultObject;

	@XmlElement(name="ResponseData")
	public ResponseData getResponseData() {
		return ResponseDataObject;
	}

	@XmlElement(name="ResponseResult")
	public ResponseResult getResponseResult() {
		return ResponseResultObject;
	}

	@Override
	public String toString() {
		return "Microvix [ResponseDataObject=" + getResponseData() + ", ResponseResultObject=" + getResponseResult()
				+ "]";
	}

	public void setResponseData(ResponseData responseDataObject) {
		ResponseDataObject = responseDataObject;
	}

	public void setResponseResult(ResponseResult responseResultObject) {
		ResponseResultObject = responseResultObject;
	}

}
