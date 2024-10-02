package ndgroups.mbrailway.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import ndgroups.mbrailway.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/paypal")
public class PaypalController {

    @Autowired
    private PaypalService paypalService;


    @GetMapping("/pay")
    public RedirectView pay() {
        String successUrl = "http://localhost:8080/paypal/success";
        String cancelUrl = "http://localhost:8080/paypal/cancel";

        try {
            Payment payment = paypalService.createPayment(
                    50.00, // Total amount
                    "USD", // Currency
                    "paypal", // Payment method
                    "sale", // Intent
                    "Payment description",
                    cancelUrl,
                    successUrl
            );

            for(Links link : payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return new RedirectView(link.getHref());
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }

//        return new RedirectView("/");
        return new RedirectView("/paypal/error");
    }

    @GetMapping("/success")
    public String successPay(@RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "paypal/success";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @GetMapping("/cancel")
    public String cancelPay() {
        return "paypal/cancel";
    }
    @GetMapping("/error")
    public String paymentError() {
        return "paypal/error";
    }

    @GetMapping("/checkout")
    public String filterReserved(){
        return "bookings/checkout";
    }
}
