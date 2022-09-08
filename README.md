# Spring Concepts

### Spring Context

We put @Controller annotation to MyController class.
@Controller annotation extends from @Component annotation.
@Component helps to autodetect our custom bean.
The beans name equals annotated class name (MyController) with first small letter (myController).   
As you can see in this example, main class could create object from MyController class without using 'new'.

Not sure, but it seems Inversion of Control, where object creating was delegate to spring. 
