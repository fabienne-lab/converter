package seg3502.converter

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
 @Controller


class WebController {
 @ModelAttribute
 fun addAttributes(model: Model) {
 model.addAttribute("error", "")
 model.addAttribute("n1", "")
 model.addAttribute("n2", "")
 }

 @RequestMapping("/")
 fun home(): String {
 return "home"
 }

 @GetMapping(value = ["/convert"])
 fun doConvert(
 @RequestParam(value = "n1", required = false) n1: String,
 @RequestParam(value = "n2", required = false) n2: String,
  @RequestParam(value = "r", required = false) r: String,
 @RequestParam(value = "operation", required = false) operation: String,
 model: Model
 ): String {
 var n1Val: Double
 var n2Val: Double
 var rVal: Double
 when (operation) {
 "plus" ->
 try {
 n1Val = n1.toDouble()
 n2Val = n2.toDouble()
 rVal=n1Val + n2Val
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 model.addAttribute("r", String.format("%.2f", rVal))
 } catch (exp: NumberFormatException) {
 model.addAttribute("error", "CelsiusFormatError")
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 }
 "moins" ->
 try {
 n1Val = n1.toDouble()
 n2Val = n2.toDouble()
 rVal=n1Val - n2Val
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 model.addAttribute("r", String.format("%.2f", rVal))
 } catch (exp: NumberFormatException) {
 model.addAttribute("error", "CelsiusFormatError")
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 }
 "times" ->
 try {
 n1Val = n1.toDouble()
 n2Val = n2.toDouble()
 rVal=n1Val * n2Val
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 model.addAttribute("r", String.format("%.2f", rVal))
 } catch (exp: NumberFormatException) {
 model.addAttribute("error", "CelsiusFormatError")
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 }
 "iv" ->
 try {
 n1Val = n1.toDouble()
 n2Val = n2.toDouble()
 rVal=n1Val / n2Val
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 model.addAttribute("r", String.format("%.2f", rVal))
 } catch (exp: NumberFormatException) {
 model.addAttribute("error", "CelsiusFormatError")
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)
 }
 else -> {
 model.addAttribute("error", "OperationFormatError")
 model.addAttribute("n1", n1)
 model.addAttribute("n2", n2)

  }
 }
 return "home"
 }
 }
