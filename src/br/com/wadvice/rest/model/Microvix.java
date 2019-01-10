package br.com.wadvice.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Microvix")
public class Microvix {
	
	ResponseData ResponseDataObject;
	ResponseResult ResponseResultObject;

	@XmlElement(name="ResponseData")
	public ResponseData getResponseData() {
		return ResponseDataObject;
	}

	public void setResponseData(ResponseData ResponseDataObject) {
		this.ResponseDataObject = ResponseDataObject;
	}

	@XmlElement(name="ResponseResult")
	public ResponseResult getResponseResult() {
		return ResponseResultObject;
	}

	public void setResponseResult(ResponseResult ResponseResultObject) {
		this.ResponseResultObject = ResponseResultObject;
	}

	@Override
	public String toString() {
		return "Microvix [ResponseDataObject=" + ResponseDataObject + ", ResponseResultObject=" + ResponseResultObject
				+ "]";
	}

}
