/*
 * package com.santander.mortgage.serviceImpl;
 * 
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit.jupiter.SpringExtension;
 * 
 * import com.santander.mortgage.controller.MortgageController; import
 * com.santander.mortgage.dto.MortgageRequestDto; import
 * com.santander.mortgage.dto.MortgageResponseDto; import
 * com.santander.mortgage.model.PropertyDetails; import
 * com.santander.mortgage.repository.PropertyDetailsRepository; import
 * com.santander.mortgage.service.MortgageService;
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @WebMvcTest(MortgageServiceImpl.class)
 * 
 * public class MortgageServiceImplTest {
 * 
 * @InjectMocks private MortgageServiceImpl mortgageServiceImpl;
 * 
 * @MockBean private PropertyDetailsRepository propertyDetailsRepository;
 * 
 * 
 * public MortgageResponseDto savePropertyDetails(MortgageRequestDto
 * mortgageRequestDto) {
 * 
 * PropertyDetails propertyDetails = new PropertyDetails();
 * propertyDetails.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
 * propertyDetails.setPropertyType(mortgageRequestDto.getPropertyType());
 * propertyDetails.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms())
 * ; propertyDetails.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
 * propertyDetails.setPropertyAge(mortgageRequestDto.getPropertyAge());
 * propertyDetails.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered(
 * )); propertyDetails.setTenureType(mortgageRequestDto.getTenureType());
 * 
 * propertyDetails=propertyDetailsRepository.save(propertyDetails);
 * 
 * MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();
 * mortgageResponseDto.setUserId(propertyDetails.getUserId().intValue());
 * mortgageResponseDto.setMessage("Property Details saved successfully");
 * 
 * return mortgageResponseDto; }
 * 
 * 
 * }
 */