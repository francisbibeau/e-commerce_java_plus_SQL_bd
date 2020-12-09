<%@include file="include/header.jsp" %>
<br><br>
<div class="container">
   <div class="row">
      <div class="col-md-5">
         <div class="form-area">  
            <form role="form" action="contact" method="post">
               <h3 style="margin-bottom: 25px; text-align: center;">Formulaire de contact</h3>
               <div class="form-group">
                  <input type="text" class="form-control" id="name" name="name" placeholder="Nom" required>
               </div>
               <div class="form-group">
                  <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" id="subject" name="subject" placeholder="Sujet" required>
               </div>
               <div class="form-group">
                  <textarea class="form-control" id="message" placeholder="Message" rows="7"></textarea>                  
               </div>
               <button type="submit" id="submit" class="btn btn-success" style="margin-left: 40%">Envoyer</button>
            </form>
         </div>
      </div>
      <div class="col-md-5">
         <div class="span4">
            <h2>BFMedicTech </h2>
            <address>
               2100 Boulevard Maisonneuve Est<br>
               1er étage<br>
               Montréal (Québec)<br>
               H2K 4S1<br>
               Courriel : info@isi-mtl.com<br>
               <abbr title="Tel">Télephone:</abbr> (514) 842-2426
            </address>
         </div>
         <div class="span8">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2795.2320568292384!2d-73.55346228444053!3d45.5255355791017!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cc91ba4da67d76d%3A0x1db0033612c25bfe!2s2100%20Boulevard%20de%20Maisonneuve%20East%2C%20Montr%C3%A9al%2C%20QC%20H2K%204S1!5e0!3m2!1sen!2sca!4v1579019538142!5m2!1sen!2sca" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
         </div>
      </div>   
   </div>
   <br><br><br><br><br><br>
</div> 