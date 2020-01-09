package com.santander.mortgage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;
import com.santander.mortgage.model.ConfirmMortgageDetails;
import com.santander.mortgage.model.MortgageOptionsDetail;
import com.santander.mortgage.repository.ConfirmMortgageRepository;
import com.santander.mortgage.repository.MortgageOptionsRepository;
import com.santander.mortgage.service.MortgageService;

@Service
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	private ConfirmMortgageRepository confirmMortgageRepository;

	@Autowired
	private MortgageOptionsRepository mortgageOptionsRepository;

	@Override
	public ConfirmMortgageResponseDto confirmMortgage(Long userId) {
		ConfirmMortgageDetails confirmMortgageDetails = confirmMortgageRepository.findByUserId(userId);
		ConfirmMortgageResponseDto confirmMortgageResponseDto = new ConfirmMortgageResponseDto();

		confirmMortgageResponseDto.setBorrowingAmount(confirmMortgageDetails.getBorrowingAmount());
		confirmMortgageResponseDto.setBuyerType(confirmMortgageDetails.getBuyerType());
		confirmMortgageResponseDto.setEstimatedPropertyValue(confirmMortgageDetails.getEstimatedPropertyValue());
		confirmMortgageResponseDto.setFollowOnRate(confirmMortgageDetails.getFollowOnRate());
		confirmMortgageResponseDto.setLoanToValue(confirmMortgageDetails.getLoanToValue());
		confirmMortgageResponseDto.setMortgageTerm(confirmMortgageDetails.getMortgageTerm());
		confirmMortgageResponseDto.setProductFeeAddedToLoanAmt(confirmMortgageDetails.getProductFeeAddedToLoanAmt());
		confirmMortgageResponseDto.setRateFinishedDate(confirmMortgageDetails.getRateFinishedDate());
		confirmMortgageResponseDto.setRepaymentMethod(confirmMortgageDetails.getRepaymentMethod());
		confirmMortgageResponseDto.setInitialRate(confirmMortgageDetails.getInitialRate());
		confirmMortgageResponseDto.setProductFee(confirmMortgageDetails.getProductFee());
		confirmMortgageResponseDto.setMonthlyRepayment(confirmMortgageDetails.getMonthlyRepayment());
		return confirmMortgageResponseDto;
	}

	@Override
	public List<MortgageOptionsResponseDto> mortgageOptions() {
		List<MortgageOptionsDetail> mortgageOptionsDetailList = mortgageOptionsRepository.findAll();
		List<MortgageOptionsResponseDto> mortgageOptionsResponseDtoList = mortgageOptionsDetailList.stream().map(e -> {
			MortgageOptionsResponseDto mortgageOptionsResponseDto = new MortgageOptionsResponseDto();
			mortgageOptionsResponseDto.setDescription(e.getDescription());
			mortgageOptionsResponseDto.setInitialRate(e.getInitialRate());
			mortgageOptionsResponseDto.setMonthlyRepayment(e.getMonthlyRepayment());
			mortgageOptionsResponseDto.setProductFee(e.getProductFee());
			return mortgageOptionsResponseDto;
		}).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		return mortgageOptionsResponseDtoList;
	}
}
