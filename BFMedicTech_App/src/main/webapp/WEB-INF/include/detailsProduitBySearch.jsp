 <br><br><br>
      <div style="width: 500px; height: 800px; display: grid; margin: auto">
         <h1 class="display-4"><%=produit.getName()%></h1>
         <br><br>
         <div class="row">
            <div class="figConteneur">         
               <img src="images/<%=produit.getImage()%>" alt="<%=produit.getImage()%>" style="with:300px;height:300px"><br><br> 
                  <a href="cartControler?id=<%=produit.getId()%>&qty=<%=produit.getStock()%>">
                  <input type="submit" id="addCartButton" value="Ajouter"> 
                  </a>
            </div>
            <div>
               <h4>Description :</h4>
               <div><%=produit.getDescription()%></div><br>
               <h4>Prix :</h4>
               <span style="color:gray;font-size: 15px">$<%=produit.getPrice()%></span> <br><br>
               <h4>Quantite en stock : </h4>
               <span style="color:gray;font-size: 15px"><%=produit.getStock()%></span>     
            </div>
         </div>
      </div>
