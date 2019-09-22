package com.timeformat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.timeformat.api.TFRequestImpl;
import com.timeformat.convert.NinetyMinuteMatchTFConversion;

@Controller
public class TimeFormatController {
	
	@Autowired
	private NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;
	
	@RequestMapping(value = "/matchTimeConvert", method = RequestMethod.GET)
    public String showPage(Model model) {
	   model.addAttribute("tfRequestImpl", new TFRequestImpl());
       return "timeformatter";
    }
    
	@RequestMapping(value = "/matchTimeConvert", method = RequestMethod.POST)
    public String showPage(@ModelAttribute("tfRequestImpl") TFRequestImpl tfRequestImpl, BindingResult errors, Model model) {
        model.addAttribute("outputTF", ninetyMinuteMatchTFConversion.convertTimeFormat(tfRequestImpl.getInputTF()).getOutputTF());
        model.addAttribute("status", ninetyMinuteMatchTFConversion.convertTimeFormat(tfRequestImpl.getInputTF()).getStatus());
        model.addAttribute("message", ninetyMinuteMatchTFConversion.convertTimeFormat(tfRequestImpl.getInputTF()).getMessage());
        return "timeformatter";
    } 
}
