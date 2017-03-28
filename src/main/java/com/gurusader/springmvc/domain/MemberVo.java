package com.gurusader.springmvc.domain;

public class MemberVo {
	private String memberId;
	private String memberPassword;
	private String memberEmail;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberVo [memberId=");
		builder.append(memberId);
		builder.append(", memberPassword=");
		builder.append(memberPassword);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append("]");
		return builder.toString();
	}
}
