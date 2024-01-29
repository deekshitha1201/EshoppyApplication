package com.example.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.NewPasswordRequest;
import com.example.Entity.Customer;
import com.example.Entity.OtpVerificationRequest;
import com.example.Entity.Product;
import com.example.Entity.Supplier;
import com.example.Repository.CustomerRespository;
import com.example.Repository.SupplierRepository;
import com.example.Service.EmailService;
import com.example.Service.OtpService;
import com.example.Service.SupplierRegisteration;
import com.example.Service.SupplierService;

@RestController
public class SupplierController {
	@Autowired
	private SupplierService supser;
	@Autowired
	private SupplierRegisteration supplierregistration;
	@Autowired
    private OtpService otpService;
	 private Map<String, Boolean> otpVerificationMap = new HashMap<>();
	   @Autowired
	    private EmailService emailService;
	   @Autowired
		private PasswordEncoder passwordEncoder;
		@Autowired
		private SupplierRepository surepo;
	@PostMapping("/save")
	public ResponseEntity<String> createrecord(@RequestBody Supplier supplier)
	{
		return new ResponseEntity<String>(supser.createrecords(supplier),HttpStatus.CREATED);
	}
	@PostMapping("/supplierregistration")
    public ResponseEntity<String> register(@RequestBody Supplier supplier) {
       return supplierregistration.savesupplier(supplier);
    }
	@GetMapping("getsupplier/{id}")
	public ResponseEntity<String> loginpage(@PathVariable Long id,@RequestBody Map<String, String> request)
	{
		String name=request.get("name");
		String password=request.get("password");
		return new ResponseEntity<String>(supser.login(id, name, password),HttpStatus.OK);
	}
	@PostMapping("/supplier/sendotp")
	public ResponseEntity<String> sendOtp(@RequestBody Supplier supplier) {
		String userEmail=supplier.getEmail();
		Supplier su=supplierregistration.findByEmail(userEmail);
		if(su==null) {
			String otp=otpService.generateOtp(userEmail);
			emailService.sendOtpEmail(userEmail, otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return ResponseEntity.badRequest().body("Supplier Email is already registered.");
			
		}
		
		}
	@PostMapping("/supplierrs/verify-otp")
    public ResponseEntity<String> verifyOtp( @RequestBody  OtpVerificationRequest verificationRequest) {
        String otp=verificationRequest.getOtp();
        String email=verificationRequest.getEmail();
        System.out.println(otp+email);

        if (otpService.validateOtp(email, otp)) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Incorrect OTP.");
        }

    }
	@PostMapping("/Forgot/sendotp")
	public ResponseEntity<String> sendotp(@RequestBody Supplier request) {
		String userEmail=request.getEmail();
		Supplier su=supplierregistration.findByEmail(userEmail);
		if(su!=null) {
			String otp=otpService.generateOtp(userEmail);
			emailService.sendOtpEmail(userEmail, otp);
			return ResponseEntity.ok("OTP sent to your email");
		} else {
			return ResponseEntity.badRequest().body("Email is not registered.");
			
		}
	}
	
	@PostMapping("/reset/{email}")
	public ResponseEntity<String> resetpassword(@RequestBody NewPasswordRequest request,@PathVariable String email) {
		String newpassword =request.getNewpassword();
		String confirmedpassword=request.getConfirmedpassword();
		Supplier sup=supplierregistration.findByEmail(email);
		if(sup==null) {
			return ResponseEntity.badRequest().body("Supplier not found");
		}  
		if(!(newpassword.equals(confirmedpassword))) {
			return ResponseEntity.badRequest().body("Passwords do not matched");
		}
		String encoddedpassword=passwordEncoder.encode(newpassword);
		sup.setPassword(encoddedpassword);
		surepo.save(sup);
		return ResponseEntity.ok("Password resetted successfully");
	}
	@PostMapping("/{sellerId}/products")
	   public ResponseEntity<String> addProductForSeller(@PathVariable Long sellerId, @RequestBody Product product) {
	       String result = supser.addProductForSupplier(sellerId, product);
	       return ResponseEntity.status(HttpStatus.CREATED).body(result);
	   }


}
